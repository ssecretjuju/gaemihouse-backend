package secretjuju.gaemihouse.room.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import secretjuju.gaemihouse.account.service.KoreaInvestmentService;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.member.service.MemberService;
import secretjuju.gaemihouse.room.dto.ShareholderRoomDTO;
import secretjuju.gaemihouse.room.dto.ShareholderRoomMemberDTO;
import secretjuju.gaemihouse.room.model.ShareholderRoom;
import secretjuju.gaemihouse.room.model.ShareholderRoomMember;
import secretjuju.gaemihouse.room.service.ShareholderRoomMemberService;
import secretjuju.gaemihouse.room.service.ShareholderRoomService;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Map;

@RestController
public class ShareholderRoomMemberController {

    private final KoreaInvestmentService koreaInvestmentService;
    private final ShareholderRoomService shareholderRoomService;
    private final ShareholderRoomMemberService shareholderRoomMemberService;
    private final MemberService memberService;

    public ShareholderRoomMemberController(KoreaInvestmentService koreaInvestmentService, ShareholderRoomService shareholderRoomService, ShareholderRoomMemberService shareholderRoomMemberService, MemberService memberService) {
        this.koreaInvestmentService = koreaInvestmentService;
        this.shareholderRoomService = shareholderRoomService;
        this.shareholderRoomMemberService = shareholderRoomMemberService;
        this.memberService = memberService;
    }

    @PostMapping("/shareholder-room/member")
    public ResponseEntity<ResponseDTO> findShareHolderRoom(@RequestBody Map<String, String> data) {

        String memberId = data.get("memberId");
        String roomTitle = data.get("roomTitle");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        ShareholderRoomMemberDTO shareholderRoomMember = shareholderRoomMemberService.findShareholderRoomMember(memberId);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.CREATED, "successful", shareholderRoomMember));
    }

    // url 설정하여 권한 설정하기
    // 방 생성 시 방장 정보 받기(member)
    @PostMapping("/shareholder-room/join")
    public ResponseEntity<ResponseDTO> joinShareHolderRoom(@RequestBody Map<String, String> data) {

        String memberId = data.get("memberId");
        String roomTitle = data.get("roomTitle");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        int currentEvaluateProperty = koreaInvestmentService.getCurrentEvaluateProperty(memberId);

        ShareholderRoomMemberDTO shareholderRoomMemberDTO;
        try {
            shareholderRoomMemberDTO = shareholderRoomMemberService.findShareholderRoomMember(memberId);

            String joinRoomTitle = shareholderRoomMemberDTO.getRoomTitle(); // 가입된 방이 있는지 확인

            return ResponseEntity
                    .badRequest()
                    .headers(headers)
                    .body(new ResponseDTO(HttpStatus.BAD_REQUEST, "fail", false)); // 이미 다른 방에 가입 되어 있는 경우

        } catch (Exception e) {

            ShareholderRoomMember shareholderRoomMember =
                    new ShareholderRoomMember(0, currentEvaluateProperty, memberId, roomTitle);

            shareholderRoomMemberService.updateShareholderRoom(shareholderRoomMember);

            ShareholderRoom tempRoom = shareholderRoomService.findShareholderRoomEntity(roomTitle);
            ShareholderRoom shareholderRoom =
                    new ShareholderRoom(tempRoom.getRoomCode(), tempRoom.getRoomTitle(),
                            tempRoom.getRoomLimitedNumber(), tempRoom.getRoomRegistedNumber() + 1, tempRoom.getRoomYield(), memberId);

            shareholderRoomService.updateRegistedNumber(shareholderRoom);

            return ResponseEntity
                    .created(URI.create("/shareholder-room/join"))
                    .headers(headers)
                    .body(new ResponseDTO(HttpStatus.CREATED, "successful", true));
        }
    }

    @PostMapping("/shareholder-room/current/evaluate-yield")
    public ResponseEntity<ResponseDTO> getCurrentMemberYield(@RequestBody Map<String, String> data) {

        String memberId = data.get("memberId");
        String roomTitle = data.get("roomTitle");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        int roomMemberCode = shareholderRoomMemberService.findShareholderRoomMember(memberId).getRoomMemberCode();
        int currentEvaluateProperty = koreaInvestmentService.getCurrentEvaluateProperty(memberId);
        int joinEvaluateProperty = shareholderRoomMemberService.findShareholderRoomMember(memberId).getJoinEvaluateProperty();

        double currentMemberYield = Math.round((currentEvaluateProperty - joinEvaluateProperty) / (double) joinEvaluateProperty * 100 * 100) / 100.0;

        ShareholderRoomMember shareholderRoomMember =
                new ShareholderRoomMember(roomMemberCode, currentMemberYield, joinEvaluateProperty, memberId, roomTitle);

        shareholderRoomMemberService.updateShareholderRoom(shareholderRoomMember); // 1인당 1방이므로 방 정보까지 필요하지 않음.

        return ResponseEntity
                .created(URI.create("/shareholder-room/current/evaluate-yield"))
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.CREATED, "successful", currentMemberYield));
    }
}
