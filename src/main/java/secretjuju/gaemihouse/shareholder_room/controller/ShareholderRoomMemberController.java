package secretjuju.gaemihouse.shareholder_room.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import secretjuju.gaemihouse.account.service.KoreaInvestmentService;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.member.service.MemberService;
import secretjuju.gaemihouse.shareholder_room.dto.ShareholderRoomMemberDTO;
import secretjuju.gaemihouse.shareholder_room.model.ShareholderRoomMember;
import secretjuju.gaemihouse.shareholder_room.service.ShareholderRoomMemberService;
import secretjuju.gaemihouse.shareholder_room.service.ShareholderRoomService;

import java.net.URI;
import java.nio.charset.Charset;

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
    public  ResponseEntity<ResponseDTO> findShareHolderRoom(/* 회원 코드, 방 코드*/) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        int memberCode = 1;
        int roomCode = 1;

        ShareholderRoomMemberDTO shareholderRoomMember = shareholderRoomMemberService.findShareholderRoomMember(memberCode);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.CREATED, "successful", shareholderRoomMember));
    }

    // url 설정하여 권한 설정하기
    @PostMapping("/shareholder-room/join")
    public ResponseEntity<ResponseDTO> joinShareHolderRoom(/* 회원 코드, 방 코드*/) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        int memberCode = 2;
        int roomCode = 1;
        int currentEvaluateProperty = koreaInvestmentService.getCurrentEvaluateProperty(/*memberCode*/);

        ShareholderRoomMember shareholderRoomMember =
                new ShareholderRoomMember(0, currentEvaluateProperty, memberCode, roomCode);

        shareholderRoomMemberService.updateShareholderRoom(shareholderRoomMember);

        return ResponseEntity
                .created(URI.create("/shareholder-room/join"))
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.CREATED, "successful", true));
    }

    @PostMapping("/current/evaluate-yield")
    public ResponseEntity<ResponseDTO> getCurrentMemberYield(/* 회원 코드, 방 코드*/) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        int memberCode = 2;
        int roomCode = 1;
        int roomMemberCode = shareholderRoomMemberService.findShareholderRoomMember(memberCode).getRoomMemberCode();
        int currentEvaluateProperty = koreaInvestmentService.getCurrentEvaluateProperty(/*memberCode*/);
        int joinEvaluateProperty = shareholderRoomMemberService.findShareholderRoomMember(memberCode).getJoinEvaluateProperty();

        double currentMemberYield = Math.round((currentEvaluateProperty - joinEvaluateProperty) / (double) joinEvaluateProperty * 100 * 100) / 100.0;

        ShareholderRoomMember shareholderRoomMember =
                new ShareholderRoomMember(roomMemberCode, currentMemberYield, joinEvaluateProperty, memberCode, roomCode);

        shareholderRoomMemberService.updateShareholderRoom(shareholderRoomMember); // 1인당 1방이므로 방 정보까지 필요하지 않음.

        return ResponseEntity
                .created(URI.create("/shareholder-room/join"))
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.CREATED, "successful", currentMemberYield));
    }
}
