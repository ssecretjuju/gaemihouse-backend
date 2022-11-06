package secretjuju.gaemihouse.report.dto;

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
public class ReportDTO {

    private int reportCode;
    private String reporterId;
    private String reportedUserId;
    private String reportDetails;

    public ReportDTO(int reportCode, String reporterId, String reportedUserId, String reportDetails) {
        this.reportCode = reportCode;
        this.reporterId = reporterId;
        this.reportedUserId = reportedUserId;
        this.reportDetails = reportDetails;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                "reportCode=" + reportCode +
                ", reporterId='" + reporterId + '\'' +
                ", reportedUserId='" + reportedUserId + '\'' +
                ", reportDetails='" + reportDetails + '\'' +
                '}';
    }

    public int getReportCode() {
        return reportCode;
    }

    public void setReportCode(int reportCode) {
        this.reportCode = reportCode;
    }

    public String getReporterId() {
        return reporterId;
    }

    public void setReporterId(String reporterId) {
        this.reporterId = reporterId;
    }

    public String getReportedUserId() {
        return reportedUserId;
    }

    public void setReportedUserId(String reportedUserId) {
        this.reportedUserId = reportedUserId;
    }

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }
}
