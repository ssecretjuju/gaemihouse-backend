package secretjuju.gaemihouse.community.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.community.dto.CommunityDTO;
import secretjuju.gaemihouse.community.service.CommunityService;

/**
 * <pre>
 * Class : CommunityController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-04       차용준          최초 생성
 * </pre>
 *
 * @author 차용준(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
@RestController
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @GetMapping("/select/{roomCode}")
    public ResponseEntity<ResponseDTO> commuintyList(@PathVariable int roomCode) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "게시판 리스트 조회 성공", communityService.selectCommunityList(roomCode)));
    }



    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertCommunity(@RequestBody CommunityDTO communityDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"게시글 작성 성공", communityService.insertCommunity(communityDTO)));
        //게시글 제목, 게시글 내용, 맴버코드, 주주방코드 받아오기
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updateCommunity(@RequestBody CommunityDTO communityDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"게시글 수정 성공", communityService.updateCommunity(communityDTO)));
        //게시글 코드, 게시글 제목, 게시글 내용, ++ 작성자 아이디 가져오기
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteCommunity(@RequestBody CommunityDTO communityDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"게시글 삭제 성공", communityService.deleteCommunity(communityDTO)));
    }

}