package secretjuju.gaemihouse.roomboard.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import secretjuju.gaemihouse.member.service.MemberService;
import secretjuju.gaemihouse.roomboard.dao.RoomBoardMapper;
import secretjuju.gaemihouse.roomboard.dto.LikeCountDTO;
import secretjuju.gaemihouse.roomboard.dto.RoomBoardDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private final MemberService memberService;

    public RoomBoardService(RoomBoardMapper roomBoardMapper, MemberService memberService) {
        this.roomBoardMapper = roomBoardMapper;
        this.memberService = memberService;
    }

    public Object selectRoomBoardList() {
        List<RoomBoardDTO> roomBoardList = roomBoardMapper.selectRoomBoardList();

        List<Map<String, Object>> resultList = new ArrayList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

        for(int i = 0; i < roomBoardList.size(); i++) {
            resultList.add(i, new HashMap<>());
            resultList.get(i).put("roomBoardCode", roomBoardList.get(i).getRoomBoardCode());
            resultList.get(i).put("roomBoardTitle", roomBoardList.get(i).getRoomBoardTitle());
            resultList.get(i).put("roomBoardContent", roomBoardList.get(i).getRoomBoardContent());
            resultList.get(i).put("roomBoardRegistDate", simpleDateFormat.format(roomBoardList.get(i).getRoomBoardRegistDate()));
            resultList.get(i).put("memberCode", roomBoardList.get(i).getMemberCode());
            resultList.get(i).put("shareholderRoomCode", roomBoardList.get(i).getShareholderRoomCode());
            resultList.get(i).put("likeCount", roomBoardList.get(i).getLikeCount());
            resultList.get(i).put("memberNickname", memberService.selectMemberInfobyCode(roomBoardList.get(i).getMemberCode()).getMemberNickname());
        }

        return resultList;
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

    @Transactional
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

        List<LikeCountDTO> likeCounts = roomBoardMapper.selectLikeCounts(likeCountDTO);

        return likeCounts;
    }

}