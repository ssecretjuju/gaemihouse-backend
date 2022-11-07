package secretjuju.gaemihouse.world.dao;

import org.apache.ibatis.annotations.Mapper;
import secretjuju.gaemihouse.world.dto.WorldDTO;

import java.util.List;

/**
 * <pre>
 * Class : CommunityMapper
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-04       홍길동           최초 생성
 * </pre>
 *
 * @author 홍길동(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
@Mapper
public interface WorldMapper {
    List<WorldDTO> selectWorldList();

    int insertWorld(WorldDTO worldDTO);

    int updateWorld(WorldDTO worldDTO);

    int deleteWorld(WorldDTO worldDTO);
}
