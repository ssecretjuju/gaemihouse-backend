package secretjuju.gaemihouse.roomboard.dao;

import org.apache.ibatis.annotations.Mapper;
import secretjuju.gaemihouse.roomboard.dto.RoomBoardDTO;

import java.util.List;

/**
 * <pre>
 * Class : RoomBoardMapper
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
@Mapper
public interface RoomBoardMapper {
    List<RoomBoardDTO> selectRoomBoardList();

    List<RoomBoardDTO> selectRoomBoardListByRoomCode(int roomCode);

    int insertRoomBoard(RoomBoardDTO roomBoardDTO);

    int updateRoomBoard(RoomBoardDTO roomBoardDTO);

    int deleteRoomBoard(RoomBoardDTO roomBoardDTO);
}