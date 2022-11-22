package secretjuju.gaemihouse.notice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.notice.dto.NoticeDTO;
import secretjuju.gaemihouse.notice.service.NoticeService;

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
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/select")
    public ResponseEntity<ResponseDTO> noticeList() {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "공지사항 리스트 조회 성공", noticeService.selectNoticeList()));
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertNotice(@RequestBody NoticeDTO noticeDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"공지사항 작성 성공", noticeService.insertNotice(noticeDTO)));
        //noticeTitle, noticeContent 넘겨주기
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updateNotice(@RequestBody NoticeDTO noticeDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"공지사항 수정 성공", noticeService.updateNotice(noticeDTO)));
        //작성 정보(수정된 정보 포함)와 추가로 noticeCode를 넘겨주어야함.
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteNotice(@RequestBody NoticeDTO noticeDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"공지사항 삭제 성공", noticeService.deleteNotice(noticeDTO)));
        //noticeCode만 넘겨주면 됨
    }

}
