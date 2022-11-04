package secretjuju.gaemihouse.notice.dto;

import java.util.Date;

/**
 * <pre>
 * Class : CommunityDTO
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
public class NoticeDTO {
    private int noticeCode;
    private String noticeTitle;
    private String noticeContent;
    private Date noticeRegistDate;

    public NoticeDTO() {}

    public NoticeDTO(int noticeCode, String noticeTitle, String noticeContent, Date noticeRegistDate) {
        this.noticeCode = noticeCode;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeRegistDate = noticeRegistDate;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "noticeCode=" + noticeCode +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeRegistDate=" + noticeRegistDate +
                '}';
    }

    public int getNoticeCode() {
        return noticeCode;
    }

    public void setNoticeCode(int noticeCode) {
        this.noticeCode = noticeCode;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public Date getNoticeRegistDate() {
        return noticeRegistDate;
    }

    public void setNoticeRegistDate(Date noticeRegistDate) {
        this.noticeRegistDate = noticeRegistDate;
    }
}
