package secretjuju.gaemihouse.payment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.payment.dto.PaymentDTO;
import secretjuju.gaemihouse.payment.service.PaymentService;

/**
 * <pre>
 * Class : PaymentController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-09       차용준            최초 생성
 * </pre>
 *
 * @author 차용준 (최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/select")
    public ResponseEntity<ResponseDTO> paymentList() {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "결제 내역 조회 성공", paymentService.selectPaymentList()));
    }

    @GetMapping("/select/{memberId}")
    public ResponseEntity<ResponseDTO> selectPaymetListById(@PathVariable("memberId") String memberId) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "결제 내역 조회 성공", paymentService.selectPaymentListById(memberId)));
    //memberId를 url에 담아서 보내기
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertPayment(@RequestBody PaymentDTO paymentDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"결제 내역 저장 성공", paymentService.insertPayment(paymentDTO)));
    //cancelYn빼고 다 넣어야함
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updatePayment(@RequestBody PaymentDTO paymentDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"결제 수정(취소) 성공", paymentService.updatePayment(paymentDTO)));
    //orderId를 가지고 옴.
    }


}
