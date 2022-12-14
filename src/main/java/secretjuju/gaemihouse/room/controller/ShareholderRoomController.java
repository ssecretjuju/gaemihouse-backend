package secretjuju.gaemihouse.room.controller;

import io.swagger.annotations.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import secretjuju.gaemihouse.account.service.KoreaInvestmentService;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.room.dto.ShareholderRoomDTO;
import secretjuju.gaemihouse.room.dto.ShareholderRoomMemberDTO;
import secretjuju.gaemihouse.room.model.ShareholderRoom;
import secretjuju.gaemihouse.room.model.ShareholderRoomMember;
import secretjuju.gaemihouse.room.service.ShareholderRoomMemberService;
import secretjuju.gaemihouse.room.service.ShareholderRoomService;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@RestController
@Api("ShareholderRoomController")
public class ShareholderRoomController {

    private final KoreaInvestmentService koreanInvestmentService;
    private final ShareholderRoomService shareholderRoomService;
    private final ShareholderRoomMemberService shareholderRoomMemberService;
    private final KoreaInvestmentService koreaInvestmentService;

    public ShareholderRoomController(KoreaInvestmentService koreanInvestmentService, ShareholderRoomService shareholderRoomService, ShareholderRoomMemberService shareholderRoomMemberService, KoreaInvestmentService koreaInvestmentService) {
        this.koreanInvestmentService = koreanInvestmentService;
        this.shareholderRoomService = shareholderRoomService;
        this.shareholderRoomMemberService = shareholderRoomMemberService;
        this.koreaInvestmentService = koreaInvestmentService;
    }

    // Unity App 로드 시 요청 => 내부맵 위에 주주방 조회
    @GetMapping("/shareholder-room")
    @ApiOperation(value = "주주방 조회", notes = "맵 오브젝트 ID를 통해 해당하는 주주방 목록 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "successful"),
            @ApiResponse(code = 404, message = "not found"),
            @ApiResponse(code = 500, message = "sever error")
    })
    public ResponseEntity<ResponseDTO> selectShareholderRoomByMapCode() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<ShareholderRoomDTO> shareholderRooms =
                shareholderRoomService.selectShareholderRoom();

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "successful", shareholderRooms));
    }

    @PostMapping("/shareholder-room")
    public ResponseEntity<ResponseDTO> insertShareholderRoom(@RequestBody Map<String, Object> requestBody) {

       ShareholderRoom shareholderRoom = new ShareholderRoom((String)requestBody.get("roomTitle"),
               (int) requestBody.get("roomLimitedNumber"), 1, 0, (String)requestBody.get("memberId"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        try {
            shareholderRoomMemberService.findShareholderRoomMember((String)requestBody.get("memberId")).getRoomTitle(); // 가입한 방이 있는지 확인

            return ResponseEntity
                    .badRequest()
                    .headers(headers)
                    .body(new ResponseDTO(HttpStatus.CREATED, "there already exists", false));

        } catch (Exception e) {
            shareholderRoomService.insertShareholderRoom(shareholderRoom);

            int property = koreanInvestmentService.getCurrentEvaluateProperty((String)requestBody.get("memberId"));
            ShareholderRoomMember shareholderRoomMember = new ShareholderRoomMember(0, property,
                    (String)requestBody.get("memberId"), (String)requestBody.get("roomTitle"));

            shareholderRoomMemberService.updateShareholderRoom(shareholderRoomMember);

            return ResponseEntity
                    .created(URI.create("/shareholder-room"))
                    .headers(headers)
                    .body(new ResponseDTO(HttpStatus.CREATED, "successful", true));
        }
    }

    @PostMapping("/shareholder-room/remove")
    public ResponseEntity<ResponseDTO> deleteShareholderRoom(@RequestBody Map<String, Object> requestBody) {

        String roomTitle = (String) requestBody.get("roomTitle");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        try {

            ShareholderRoomDTO shareholderRoom = shareholderRoomService.findShareholderRoom(roomTitle);

            shareholderRoomService.deleteShareholderRoom(shareholderRoom.getRoomTitle());

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(new ResponseDTO(HttpStatus.OK, "successful", true));

        } catch(Exception e) {

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(new ResponseDTO(HttpStatus.OK, "fail", false));
        }

    }

    @GetMapping("/shareholder-room/{roomTitle}")
    public ResponseEntity<ResponseDTO> getShareholderRoomByRoomTitle(@PathVariable String roomTitle) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        double shareholderRoomYield =
                shareholderRoomMemberService.findShareholderRoomYieldByRoomCode(roomTitle);

        ShareholderRoomDTO shareholderRoom =
                shareholderRoomService.findShareholderRoom(roomTitle);

        ShareholderRoom shareholderRoomEntity =
                new ShareholderRoom(shareholderRoom.getRoomCode(), shareholderRoom.getRoomTitle(),
                        shareholderRoom.getRoomLimitedNumber(), shareholderRoom.getRoomRegistedNumber(),
                        shareholderRoomYield, shareholderRoom.getMemberId());

        shareholderRoomService.updateRoomYield(shareholderRoomEntity);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "successful", shareholderRoom));
    }

    @GetMapping("/shareholder-room/members/{roomTitle}")
    public ResponseEntity<ResponseDTO> getShareholderRoomMembers(@PathVariable String roomTitle) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<ShareholderRoomMemberDTO> shareholderRoomMembers =
                shareholderRoomMemberService.findShareholderRoomMemberAllByRoomTitle(roomTitle);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "successful", shareholderRoomMembers));
    }

    @GetMapping("/shareholder-room/yield/{roomTitle}")
    public ResponseEntity<ResponseDTO> getShareholderRoomYield(@PathVariable String roomTitle) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        double shareholderRoomYield =
                shareholderRoomMemberService.findShareholderRoomYieldByRoomCode(roomTitle);

        ShareholderRoom shareholderRoom = shareholderRoomService.findShareholderRoomEntity(roomTitle);
        ShareholderRoom updateShareholderRoom =
                new ShareholderRoom(shareholderRoom.getRoomCode(), shareholderRoom.getRoomTitle(),
                        shareholderRoom.getRoomLimitedNumber(), shareholderRoom.getRoomRegistedNumber(),
                        shareholderRoomYield, shareholderRoom.getMemberId());

        shareholderRoomService.updateRoomYield(updateShareholderRoom);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "successful", shareholderRoomYield));
    }

    @PostMapping("/shareholder-room/entrance")
    public ResponseEntity<ResponseDTO> enterShareHolderRoom(@RequestBody Map<String, String> data) {

        String memberId = data.get("memberId");
        String roomTitle = data.get("roomTitle");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        ShareholderRoomMemberDTO shareholderRoomMember;
        try {
            shareholderRoomMember = shareholderRoomMemberService.findShareholderRoomMember(memberId);

            String joinRoomTitle = shareholderRoomMember.getRoomTitle();

            if (joinRoomTitle.equals(roomTitle)) {
                return ResponseEntity
                        .ok()
                        .headers(headers)
                        .body(new ResponseDTO(HttpStatus.OK, "successful", 1)); // 입장 가능 => 바로 입장
            } else {
                return ResponseEntity
                        .ok()
                        .headers(headers)
                        .body(new ResponseDTO(HttpStatus.OK, "successful", -1)); // 입장 불가 => 이미 다른 방 가입 창
            }

        } catch(Exception e) {
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(new ResponseDTO(HttpStatus.OK, "successful", 0)); // 정보 없음 => 가입 창
        }
    }
}
