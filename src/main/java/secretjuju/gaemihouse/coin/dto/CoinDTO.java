package secretjuju.gaemihouse.coin.dto;

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
public class CoinDTO {

    private String memberId;
    private int coinAmount;

    public CoinDTO() {};

    public CoinDTO(String memberId, int coinAmount) {
        this.memberId = memberId;
        this.coinAmount = coinAmount;
    }

    @Override
    public String toString() {
        return "CoinDTO{" +
                "memberId=" + memberId +
                ", coinAmount=" + coinAmount +
                '}';
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getCoinAmount() {
        return coinAmount;
    }

    public void setCoinAmount(int coinAmount) {
        this.coinAmount = coinAmount;
    }
}
