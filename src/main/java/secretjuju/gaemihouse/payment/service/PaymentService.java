package secretjuju.gaemihouse.payment.service;

import org.springframework.stereotype.Service;
import secretjuju.gaemihouse.payment.dao.PaymentMapper;
import secretjuju.gaemihouse.payment.dto.PaymentDTO;

import java.util.List;

/**
 * <pre>
 * Class : PaymentService
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
@Service
public class PaymentService {

    private final PaymentMapper paymentMapper;

    public PaymentService(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    public Object selectPaymentList() {
        List<PaymentDTO> paymentList = paymentMapper.selectPaymentList();
        return paymentList;
    }

    public Object insertPayment(PaymentDTO paymentDTO) {
        int insertPayment = paymentMapper.insertPayment(paymentDTO);
        return (insertPayment > 0) ? "결제 내역 입력 성공!" : "결제 내역 입력 실패 ㅜ";
    }

    public Object updatePayment(PaymentDTO paymentDTO) {
        int updatePayment = paymentMapper.updatePayment(paymentDTO);
        return (updatePayment > 0) ? "결제 수정(취소) 성공!" : "결제 수정(취소) 실패 ㅜ";
    }


    public Object selectPaymentListById(String memberId) {
        List<PaymentDTO> paymentList = paymentMapper.selectPaymentListById(memberId);
        return paymentList;
    }
}
