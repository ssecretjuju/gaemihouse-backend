package secretjuju.gaemihouse.world.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.world.dto.WorldDTO;
import secretjuju.gaemihouse.world.service.WorldService;

/**
 * <pre>
 * Class : CommunityController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-04       차용준           최초 생성
 * </pre>
 *
 * @author 차용준(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
@RestController
@RequestMapping("/world")
public class worldController {

    private final WorldService worldService;

    public worldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @GetMapping("/select")
    public ResponseEntity<ResponseDTO> worldList() {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "월드 리스트 조회 성공", worldService.selectWorldList()));
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertWorld(@RequestBody WorldDTO worldDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"월드 작성 성공", worldService.insertWorld(worldDTO)));

    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updateWorld(@RequestBody WorldDTO worldDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"월드 수정 성공", worldService.updateWorld(worldDTO)));

    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteWorld(@RequestBody WorldDTO worldDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"월드 삭제 성공", worldService.deleteWorld(worldDTO)));

    }

}
