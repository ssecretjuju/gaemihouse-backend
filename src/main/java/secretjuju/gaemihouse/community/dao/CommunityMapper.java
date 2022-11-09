package secretjuju.gaemihouse.community.dao;

import org.apache.ibatis.annotations.Mapper;
import secretjuju.gaemihouse.community.dto.CommunityDTO;

import java.util.List;

/**
 * <pre>
 * Class : CommunityMapper
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
 */
@Mapper
public interface CommunityMapper {
    List<CommunityDTO> selectCommunityList();

    int insertCommunity(CommunityDTO communityDTO);

    int updateCommunity(CommunityDTO communityDTO);

    int deleteCommunity(CommunityDTO communityDTO);
}
