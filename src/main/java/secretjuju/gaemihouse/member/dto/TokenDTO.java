package secretjuju.gaemihouse.member.dto;

/**
 * <pre>
 * Class : TokenDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-24       차용준           최초 생성
 * </pre>
 *
 * @author 차용준(최초 작성자)
 * @version 1(클래스 버전)
 */

public class TokenDTO {
    private String grantType;
    private String memberName;
    private String accessToken;
    private Long accessTokenExpiresIn;
    private int memberCode;

    public TokenDTO() {
    }

    public TokenDTO(String grantType, String memberName, String accessToken, Long accessTokenExpiresIn, int memberCode) {
        this.grantType = grantType;
        this.memberName = memberName;
        this.accessToken = accessToken;
        this.accessTokenExpiresIn = accessTokenExpiresIn;
        this.memberCode = memberCode;
    }

    @Override
    public String toString() {
        return "TokenDTO{" +
                "grantType='" + grantType + '\'' +
                ", memberName='" + memberName + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", accessTokenExpiresIn=" + accessTokenExpiresIn +
                ", memberCode=" + memberCode +
                '}';
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getAccessTokenExpiresIn() {
        return accessTokenExpiresIn;
    }

    public void setAccessTokenExpiresIn(Long accessTokenExpiresIn) {
        this.accessTokenExpiresIn = accessTokenExpiresIn;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }
}