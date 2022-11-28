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

    private int memberCode;
    private int coinAmount;

    public CoinDTO() {};

    public CoinDTO(int memberCode, int coinAmount) {
        this.memberCode = memberCode;
        this.coinAmount = coinAmount;
    }

    @Override
    public String toString() {
        return "CoinDTO{" +
                "memberCode=" + memberCode +
                ", coinAmount=" + coinAmount +
                '}';
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public int getCoinAmount() {
        return coinAmount;
    }

    public void setCoinAmount(int coinAmount) {
        this.coinAmount = coinAmount;
    }

}
