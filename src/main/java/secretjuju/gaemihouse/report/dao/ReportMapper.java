package secretjuju.gaemihouse.report.dao;

import org.apache.ibatis.annotations.Mapper;
import secretjuju.gaemihouse.member.dto.MemberDTO;
import secretjuju.gaemihouse.report.dto.ReportDTO;

import java.util.List;

/**
 * <pre>
 * Class : CommunityMapper
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
@Mapper
public interface ReportMapper {
    int insertReport(ReportDTO reportDTO);
    int updateReportCount(ReportDTO reportDTO);
    int reportCount(MemberDTO memberDTO);
}
