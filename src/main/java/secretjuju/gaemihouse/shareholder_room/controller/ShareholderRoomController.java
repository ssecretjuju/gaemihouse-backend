package secretjuju.gaemihouse.shareholder_room.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import secretjuju.gaemihouse.avatar.dto.AvatarDTO;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.shareholder_room.dto.ShareholderRoomDTO;
import secretjuju.gaemihouse.shareholder_room.service.ShareholderRoomService;

import java.nio.charset.Charset;
import java.util.Map;

@RestController
public class ShareholderRoomController {

    private final ShareholderRoomService shareholderRoomService;

    public ShareholderRoomController(ShareholderRoomService shareholderRoomService) {
        this.shareholderRoomService = shareholderRoomService;
    }

    // Unity App 로드 시 요청 => 내부맵 위에 주주방 조회
    @GetMapping("/shareholder-room")
    public ResponseEntity<ResponseDTO> selectShareholderRoomByMapCode(@RequestBody Map<String, Object> requestBody) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        int internalMapCode = (int) requestBody.get("mapCode");

        ShareholderRoomDTO shareholderRoomDTO =
                shareholderRoomService.selectShareholderRoomByMapCode(internalMapCode);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "successful", shareholderRoomDTO));
    }
}
