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
import java.util.Map;

@RestController
public class AvatarController {

    private AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    // Unity App 로드 시 회원 정보를 포함하여 요청 => 아바타 정보 반환
    @GetMapping("/avatar")
    public ResponseEntity<ResponseDTO> selectAvatarByMemberCode(@RequestBody Map<String, Object> requestBody) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        int memberCode = (int) requestBody.get("memberCode");

        AvatarDTO avatarDTO = avatarService.selectAvatarByMemberCode(memberCode);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "successful", avatarDTO));
    }

    @PostMapping("/avatar")
    public ResponseEntity<ResponseDTO> insertAvatarByMemberCode(@RequestBody Map<String, Object> requestBody) {

        Avatar avatar = new Avatar((int) requestBody.get("avatarId"), (int) requestBody.get("memberCode"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        boolean insertResult = avatarService.insertAvatarByMemberCode(avatar);


        return ResponseEntity
                .created(URI.create("/avatar"))
                .body(new ResponseDTO(HttpStatus.CREATED,
                        insertResult? "Generate avatar successfully" : "Already avatar exists",
                        insertResult));
    }

}
