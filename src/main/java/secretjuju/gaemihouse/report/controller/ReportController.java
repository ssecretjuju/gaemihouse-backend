package secretjuju.gaemihouse.report.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.member.dto.MemberDTO;
import secretjuju.gaemihouse.report.dto.ReportDTO;
import secretjuju.gaemihouse.report.service.ReportService;

/**
 * <pre>
 * Class : CommunityController
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
@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/details")
    public ResponseEntity<ResponseDTO> insertReport(@RequestBody ReportDTO reportDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"신고내역 접수 성공", reportService.insertReport(reportDTO)));
    }



}
