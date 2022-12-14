package secretjuju.gaemihouse.report.service;

import org.springframework.stereotype.Service;
import secretjuju.gaemihouse.member.dto.MemberDTO;
import secretjuju.gaemihouse.report.dao.ReportMapper;
import secretjuju.gaemihouse.report.dto.ReportDTO;

import java.util.List;

/**
 * <pre>
 * Class : CommunityService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-04       차용준            최초 생성
 * </pre>
 *
 * @author 차용준 (최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
@Service
public class ReportService {

    private final ReportMapper reportMapper;

    public ReportService(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    public Object insertReport(ReportDTO reportDTO) {
        int insertReport = reportMapper.insertReport(reportDTO);
        int updateReportCount = reportMapper.updateReportCount(reportDTO);



        return (insertReport > 0) ? "신고 내역 입력 성공!" : "신고 내역 입력 실패 ㅜ";
    }


}
