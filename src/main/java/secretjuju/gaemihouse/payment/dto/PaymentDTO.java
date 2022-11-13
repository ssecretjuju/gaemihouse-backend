package secretjuju.gaemihouse.payment.dto;

import java.util.Date;

/**
 * <pre>
 * Class : PaymentDTO
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
public class PaymentDTO {
    private int amount;
    private String orderId;
    private String orderName;
    private String customerName;
    private String successUrl;
    private String failUrl;
    private String cancelYn;

    public PaymentDTO() {}

    public PaymentDTO(int amount, String orderId, String orderName, String customerName,
                      String successUrl, String failUrl, String cancelYn) {
        this.amount = amount;
        this.orderId = orderId;
        this.orderName = orderName;
        this.customerName = customerName;
        this.successUrl = successUrl;
        this.failUrl = failUrl;
        this.cancelYn = cancelYn;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "amount=" + amount +
                ", orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", successUrl='" + successUrl + '\'' +
                ", failUrl='" + failUrl + '\'' +
                ", cancelYn='" + cancelYn + '\'' +
                '}';
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailUrl() {
        return failUrl;
    }

    public void setFailUrl(String failUrl) {
        this.failUrl = failUrl;
    }

    public String getCancelYn() {
        return cancelYn;
    }

    public void setCancelYn(String cancelYn) {
        this.cancelYn = cancelYn;
    }
}
