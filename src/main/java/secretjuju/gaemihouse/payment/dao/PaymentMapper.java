package secretjuju.gaemihouse.payment.dao;

import org.apache.ibatis.annotations.Mapper;
import secretjuju.gaemihouse.payment.dto.PaymentDTO;

import java.util.List;

/**
 * <pre>
 * Class : PaymentMapper
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
@Mapper
public interface PaymentMapper {

    List<PaymentDTO> selectPaymentList();

    int insertPayment(PaymentDTO paymentDTO);

    int updatePayment(PaymentDTO paymentDTO);

    List<PaymentDTO> selectPaymentListById(String memberId);
}
