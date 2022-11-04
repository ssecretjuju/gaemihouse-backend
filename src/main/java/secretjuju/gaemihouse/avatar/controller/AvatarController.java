package secretjuju.gaemihouse.avatar.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import secretjuju.gaemihouse.avatar.dto.AvatarDTO;
import secretjuju.gaemihouse.avatar.service.AvatarService;
import secretjuju.gaemihouse.common.ResponseDTO;

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
}
