package secretjuju.gaemihouse.world.service;

import org.springframework.stereotype.Service;
import secretjuju.gaemihouse.world.dao.WorldMapper;
import secretjuju.gaemihouse.world.dto.WorldDTO;

import java.util.List;

/**
 * <pre>
 * Class : CommunityService
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
@Service
public class WorldService {

    private final WorldMapper worldMapper;

    public WorldService(WorldMapper worldMapper) {
        this.worldMapper = worldMapper;
    }

    public Object selectWorldList() {
        List<WorldDTO> worldList = worldMapper.selectWorldList();
        return worldList;
    }

    public Object insertWorld(WorldDTO worldDTO) {
        int insertWorld = worldMapper.insertWorld(worldDTO);
        return (insertWorld > 0) ? "공지사항 입력 성공!" : "공지사항 입력 실패 ㅜ";
    }

    public Object updateWorld(WorldDTO worldDTO) {
        int updateWorld = worldMapper.updateWorld(worldDTO);
        return (updateWorld > 0) ? "공지사항 수정 성공!" : "공지사항 수정 실패 ㅜ";
    }

    public Object deleteWorld(WorldDTO worldDTO) {
        int deleteWorld = worldMapper.deleteWorld(worldDTO);
        return (deleteWorld > 0) ? "공지사항 삭제 성공!" : "공지사항 삭제 실패 ㅠ";
    }
}
