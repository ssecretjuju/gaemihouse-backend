package secretjuju.gaemihouse.community.service;

import org.springframework.stereotype.Service;
import secretjuju.gaemihouse.community.dao.CommunityMapper;
import secretjuju.gaemihouse.community.dto.CommunityDTO;

import java.util.List;

/**
 * <pre>
 * Class : CommunityService
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
@Service
public class CommunityService {

    private final CommunityMapper communityMapper;

    public CommunityService(CommunityMapper communityMapper) {
        this.communityMapper = communityMapper;
    }

    public Object selectCommunityList(int roomCode) {
        List<CommunityDTO> communityList = communityMapper.selectCommunityList(roomCode);
        return communityList;
    }

    public Object insertCommunity(CommunityDTO communityDTO) {
        int insertCommunity = communityMapper.insertCommunity(communityDTO);
        return (insertCommunity > 0) ? "게시글 입력 성공!" : "게시글 입력 실패 ㅜ";
    }

    public Object updateCommunity(CommunityDTO communityDTO) {
        int updateCommunity = communityMapper.updateCommunity(communityDTO);
        return (updateCommunity > 0) ? "게시글 수정 성공!" : "게시글 수정 실패 ㅜ";
    }

    public Object deleteCommunity(CommunityDTO communityDTO) {
        int deleteCommunity = communityMapper.deleteCommunity(communityDTO);
        return (deleteCommunity > 0) ? "게시글 삭제 성공!" : "게시글 삭제 실패 ㅠ";
    }
}
