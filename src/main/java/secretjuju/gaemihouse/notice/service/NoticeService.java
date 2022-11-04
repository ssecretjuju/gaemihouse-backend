package secretjuju.gaemihouse.notice.service;

import org.springframework.stereotype.Service;
import secretjuju.gaemihouse.notice.dao.NoticeMapper;
import secretjuju.gaemihouse.notice.dto.NoticeDTO;

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
public class NoticeService {

    private final NoticeMapper noticeMapper;

    public NoticeService(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public Object selectNoticeList() {
        List<NoticeDTO> noticeList = noticeMapper.selectNoticeList();
        return noticeList;
    }

    public Object insertNotice(NoticeDTO noticeDTO) {
        int insertNotice = noticeMapper.insertNotice(noticeDTO);
        return (insertNotice > 0) ? "게시글 입력 성공!" : "게시글 입력 실패 ㅜ";
    }

    public Object updateNotice(NoticeDTO noticeDTO) {
        int updateNotice = noticeMapper.updateNotice(noticeDTO);
        return (updateNotice > 0) ? "게시글 수정 성공!" : "게시글 수정 실패 ㅜ";
    }

    public Object deleteNotice(NoticeDTO noticeDTO) {
        int deleteNotice = noticeMapper.deleteNotice(noticeDTO);
        return (deleteNotice > 0) ? "게시글 삭제 성공!" : "게시글 삭제 실패 ㅠ";
    }
}
