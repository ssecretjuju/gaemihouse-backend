package secretjuju.gaemihouse.roomboard.service;

import org.springframework.stereotype.Service;
import secretjuju.gaemihouse.roomboard.controller.RoomBoardController;
import secretjuju.gaemihouse.roomboard.dao.RoomBoardMapper;
import secretjuju.gaemihouse.roomboard.dto.LikeCountDTO;
import secretjuju.gaemihouse.roomboard.dto.RoomBoardDTO;

import java.util.List;

/**
 * <pre>
 * Class : RoomBoardService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-21       차용준           최초 생성
 * </pre>
 *
 * @author 차용준(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
@Service
public class RoomBoardService {

    private final RoomBoardMapper roomBoardMapper;

    public RoomBoardService(RoomBoardMapper roomBoardMapper) {
        this.roomBoardMapper = roomBoardMapper;
    }

    public Object selectRoomBoardList() {
        List<RoomBoardDTO> roomBoardList = roomBoardMapper.selectRoomBoardList();
        return roomBoardList;
    }

    public Object selectRoomBoardListByRoomCode(int roomCode) {
        List<RoomBoardDTO> roomBoardListByRoomCode = roomBoardMapper.selectRoomBoardListByRoomCode(roomCode);
        return roomBoardListByRoomCode;
    }

    public Object insertRoomBoard(RoomBoardDTO roomBoardDTO) {
        int insertRoomBoard = roomBoardMapper.insertRoomBoard(roomBoardDTO);
        return (insertRoomBoard > 0) ? "게시글 입력 성공!" : "게시글 입력 실패 ㅜ";
    }

    public Object updateRoomBoard(RoomBoardDTO roomBoardDTO) {
        int updateRoomBoard = roomBoardMapper.updateRoomBoard(roomBoardDTO);
        return (updateRoomBoard > 0) ? "게시글 수정 성공!" : "게시글 수정 실패 ㅜ";
    }

    public Object deleteRoomBoard(RoomBoardDTO roomBoardDTO) {
        int deleteRoomBoard = roomBoardMapper.deleteRoomBoard(roomBoardDTO);
        return (deleteRoomBoard > 0) ? "게시글 삭제 성공!" : "게시글 삭제 실패 ㅠ";
    }

    public Object updateLikeCount(LikeCountDTO likeCountDTO) {

        List<LikeCountDTO> checkLikeList = roomBoardMapper.CheckLikeList(likeCountDTO);

        int checkLikeListSize = checkLikeList.size();
        System.out.println("checkLikeListSize : " + checkLikeListSize);

        if(checkLikeListSize == 1) {
            LikeCountDTO checkLikePushed = roomBoardMapper.CheckLikePushed(likeCountDTO);
            System.out.println("checkLikePushed.getPushedYn() : " + checkLikePushed.getPushedYn());

            if(checkLikePushed.getPushedYn().equals("N")){
                int ChangePlusLikeCountTable = roomBoardMapper.ChangePlusLikeCountTable(likeCountDTO);
                int ChangePlusRoomBoardTable = roomBoardMapper.ChangePlusRoomBoardTable(likeCountDTO);
                int ChangePlusMemberTable = roomBoardMapper.ChangePlusMemberTable(likeCountDTO);
                System.out.println("likeCountDTO : " + likeCountDTO);
                System.out.println( "ChangePlusLikeCountTable : " + ChangePlusLikeCountTable);
                System.out.println( "ChangePlusRoomBoardTable : " + ChangePlusRoomBoardTable);
                System.out.println( "ChangePlusMemberTable : " + ChangePlusMemberTable);
            } else if (checkLikePushed.getPushedYn().equals("Y")) {
                int ChangeMinusLikeCountTable = roomBoardMapper.ChangeMinusLikeCountTable(likeCountDTO);
                int ChangeMinusRoomBoardTable = roomBoardMapper.ChangeMinusRoomBoardTable(likeCountDTO);
                int ChangeMinusMemberTable = roomBoardMapper.ChangeMinusMemberTable(likeCountDTO);
                System.out.println("likeCountDTO : " + likeCountDTO);
                System.out.println( "ChangeMinusLikeCountTable : " + ChangeMinusLikeCountTable);
                System.out.println( "ChangeMinusRoomBoardTable : " + ChangeMinusRoomBoardTable);
                System.out.println( "ChangeMinusMemberTable : " + ChangeMinusMemberTable);
            }
        }else if(checkLikeListSize == 0){
            int insertLikeCount = roomBoardMapper.insertLikeCount(likeCountDTO);
            int ChangePlusLikeCountTable = roomBoardMapper.ChangePlusLikeCountTable(likeCountDTO);
            int ChangePlusRoomBoardTable = roomBoardMapper.ChangePlusRoomBoardTable(likeCountDTO);
            int ChangePlusMemberTable = roomBoardMapper.ChangePlusMemberTable(likeCountDTO);
            System.out.println("insertLikeCount : " + insertLikeCount);
            System.out.println("likeCountDTO : " + likeCountDTO);
            System.out.println( "ChangePlusLikeCountTable : " + ChangePlusLikeCountTable);
            System.out.println( "ChangePlusRoomBoardTable : " + ChangePlusRoomBoardTable);
            System.out.println( "ChangePlusMemberTable : " + ChangePlusMemberTable);
        }

        return checkLikeList;
    }

}