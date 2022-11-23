package secretjuju.gaemihouse.avatar.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import secretjuju.gaemihouse.avatar.dto.AvatarDTO;
import secretjuju.gaemihouse.avatar.model.Avatar;
import secretjuju.gaemihouse.avatar.service.AvatarService;
import secretjuju.gaemihouse.common.ResponseDTO;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@RestController
public class AvatarController {

    private AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    // Unity App 로드 시 회원 정보를 포함하여 요청 => 아바타 정보 반환
    @GetMapping("/avatar")
    public ResponseEntity<ResponseDTO> selectAvatarByMemberId(@RequestBody Map<String, Object> requestBody) {

        String memberId = (String) requestBody.get("memberId");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        AvatarDTO avatarDTO;
        try {
            avatarDTO = avatarService.selectAvatarByMemberId(memberId);

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(new ResponseDTO(HttpStatus.OK, "successful", avatarDTO));
        } catch (Exception e) {
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(new ResponseDTO(HttpStatus.OK, "not exist", null));
        }

    }

    // 아바타 생성 시 요청
    @PostMapping("/avatar")
    public ResponseEntity<ResponseDTO> insertAvatarByMemberCode(@RequestBody Map<String, Object> requestBody) {

        Avatar avatar = new Avatar((String) requestBody.get("memberId"),
                (int) requestBody.get("faceType"), (int) requestBody.get("bodyType"), (int) requestBody.get("accType"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        boolean insertResult = avatarService.insertAvatarByMemberCode(avatar);


        return ResponseEntity
                .created(URI.create("/avatar"))
                .body(new ResponseDTO(HttpStatus.CREATED,
                        insertResult? "Generate avatar successfully" : "Already avatar exists",
                        insertResult));
    }

    // 아바타 수정 시 요청
    @PutMapping("/avatar")
    public ResponseEntity<ResponseDTO> updateAvatarByMemberCode(@RequestBody Map<String, Object> requestBody) {

        Avatar avatar = new Avatar((String) requestBody.get("memberId"),
                (int) requestBody.get("faceType"), (int) requestBody.get("bodyType"), (int) requestBody.get("accType"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        boolean updateResult = avatarService.updateAvatarByMemberCode(avatar);

        if (updateResult) {
            return ResponseEntity
                    .created(URI.create("/avatar"))
                    .body(new ResponseDTO(HttpStatus.CREATED, "Update avatar successfully", true));

        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseDTO(HttpStatus.BAD_REQUEST, "Fail to update avatar", false));
        }
    }

    // 회원 탈퇴 시 요청
    @DeleteMapping("/avatar")
    public ResponseEntity<ResponseDTO> deleteAvatarByMemberCode(@RequestBody Map<String, Object> requestBody) {

        Avatar avatar = new Avatar((String) requestBody.get("memberId"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        boolean deleteResult = avatarService.deleteAvatarByMemberCode(avatar);

        if (deleteResult) {
            return ResponseEntity
                    .noContent()
                    .build();

        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseDTO(HttpStatus.BAD_REQUEST, "Delete failed", false));
        }
    }

    @GetMapping("/")
    public String test() {
        return "Server is opened.";
    }
}
