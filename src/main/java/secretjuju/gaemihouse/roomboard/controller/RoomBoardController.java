package secretjuju.gaemihouse.roomboard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.roomboard.dto.LikeCountDTO;
import secretjuju.gaemihouse.roomboard.dto.RoomBoardDTO;
import secretjuju.gaemihouse.roomboard.service.RoomBoardService;

/**
 * <pre>
 * Class : RoomBoardController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-21       차용준          최초 생성
 * </pre>
 *
 * @author 차용준(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */


@RestController
@RequestMapping("/roomBoard")
public class RoomBoardController {

    private final RoomBoardService roomBoardService;

    public RoomBoardController(RoomBoardService roomBoardService) {
        this.roomBoardService = roomBoardService;
    }

    @GetMapping("/select")
    public ResponseEntity<ResponseDTO> roomBoardList() {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "게시판 리스트 조회 성공", roomBoardService.selectRoomBoardList()));
    }

    @GetMapping("/select/{roomCode}")
    public ResponseEntity<ResponseDTO> roomBoardList(@PathVariable int roomCode) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "게시판 리스트 조회 성공", roomBoardService.selectRoomBoardListByRoomCode(roomCode)));
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertroomBoard(@RequestBody RoomBoardDTO roomBoardDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"게시글 작성 성공", roomBoardService.insertRoomBoard(roomBoardDTO)));
        //게시글 제목, 게시글 내용, 맴버코드, 주주방코드 받아오기
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updateroomBoard(@RequestBody RoomBoardDTO roomBoardDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"게시글 수정 성공", roomBoardService.updateRoomBoard(roomBoardDTO)));
        //게시글 코드, 게시글 제목, 게시글 내용, ++ 작성자 아이디 가져오기
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteroomBoard(@RequestBody RoomBoardDTO roomBoardDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"게시글 삭제 성공", roomBoardService.deleteRoomBoard(roomBoardDTO)));
    }

    @PostMapping("/updatelikecount")
    public ResponseEntity<ResponseDTO> updateLikeCount(@RequestBody LikeCountDTO likeCountDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"좋아요 수정 성공", roomBoardService.updateLikeCount(likeCountDTO)));
    }

}