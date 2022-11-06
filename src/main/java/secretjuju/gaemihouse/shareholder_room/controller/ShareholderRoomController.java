package secretjuju.gaemihouse.shareholder_room.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.shareholder_room.dto.ShareholderRoomDTO;
import secretjuju.gaemihouse.shareholder_room.model.ShareholderRoom;
import secretjuju.gaemihouse.shareholder_room.service.ShareholderRoomService;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@RestController
public class ShareholderRoomController {

    private final ShareholderRoomService shareholderRoomService;

    public ShareholderRoomController(ShareholderRoomService shareholderRoomService) {
        this.shareholderRoomService = shareholderRoomService;
    }

    // Unity App 로드 시 요청 => 내부맵 위에 주주방 조회
    @GetMapping("/shareholder-room")
    public ResponseEntity<ResponseDTO> selectShareholderRoomByMapCode(@RequestParam(name = "mapcode") int mapCode) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<ShareholderRoomDTO> shareholderRooms =
                shareholderRoomService.selectShareholderRoomByMapCode(mapCode);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "successful", shareholderRooms));
    }

    @PostMapping("/shareholder-room")
    public ResponseEntity<ResponseDTO> insertShareholderRoom(@RequestBody Map<String, Object> requestBody) {

       ShareholderRoom shareholderRoom = new ShareholderRoom((int) requestBody.get("roomCode"),
               (int) requestBody.get("roomLimitedNumber"), 1, 0, (int) requestBody.get("mapCode"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        shareholderRoomService.insertShareholderRoom(shareholderRoom);

        return ResponseEntity
                .created(URI.create("/shareholder-room"))
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.CREATED, "successful", true));
    }

    @DeleteMapping("/shareholder-room")
    public ResponseEntity<ResponseDTO> deleteShareholderRoom(@RequestBody Map<String, Object> requestBody) {

        int roomCode = (int) requestBody.get("roomCode");

        shareholderRoomService.deleteShareholderRoom(roomCode);

        return ResponseEntity
                .noContent()
                .build();
    }
}