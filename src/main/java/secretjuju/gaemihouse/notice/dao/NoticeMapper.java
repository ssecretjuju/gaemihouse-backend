package secretjuju.gaemihouse.notice.dao;

import org.apache.ibatis.annotations.Mapper;
import secretjuju.gaemihouse.notice.dto.NoticeDTO;

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
public interface NoticeMapper {
    List<NoticeDTO> selectNoticeList();

    int insertNotice(NoticeDTO noticeDTO);

    int updateNotice(NoticeDTO noticeDTO);

    int deleteNotice(NoticeDTO noticeDTO);
}
