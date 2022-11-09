package secretjuju.gaemihouse.member.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
/**
 * <pre>
 * Class : MemberDTO
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
 * @see (참고할 class 또는 외부 url)
 */
public class MemberDTO implements UserDetails {

    private int memberCode;
    private String memberId;
    private String memberPassword;
    private String memberRole;
    private String memberNickname;
    private String memberName;
    private String stockFirm;
    private String accountNum;
    private String appKey;
    private String appSecret;
    private Date appKeyExpiresin;
    private String termsAgreementYn;
    private int reportCount;
    private String blacklistYn;
    private String stockCareer;
    private String withdrawYn;

    public MemberDTO() {}

    public MemberDTO(int memberCode, String memberId, String memberPassword, String memberRole,
                     String memberNickname, String memberName, String stockFirm, String accountNum,
                     String appKey, String appSecret, Date appKeyExpiresin, String termsAgreementYn,
                     int reportCount, String blacklistYn, String stockCareer, String withdrawYn,
                     Collection<? extends GrantedAuthority> authorities) {
        this.memberCode = memberCode;
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberRole = memberRole;
        this.memberNickname = memberNickname;
        this.memberName = memberName;
        this.stockFirm = stockFirm;
        this.accountNum = accountNum;
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.appKeyExpiresin = appKeyExpiresin;
        this.termsAgreementYn = termsAgreementYn;
        this.reportCount = reportCount;
        this.blacklistYn = blacklistYn;
        this.stockCareer = stockCareer;
        this.withdrawYn = withdrawYn;
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberId='" + memberId + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberRole='" + memberRole + '\'' +
                ", memberNickname='" + memberNickname + '\'' +
                ", memberName='" + memberName + '\'' +
                ", stockFirm='" + stockFirm + '\'' +
                ", accountNum='" + accountNum + '\'' +
                ", appKey='" + appKey + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", appKeyExpiresin=" + appKeyExpiresin +
                ", termsAgreementYn='" + termsAgreementYn + '\'' +
                ", reportCount=" + reportCount +
                ", blacklistYn='" + blacklistYn + '\'' +
                ", stockCareer='" + stockCareer + '\'' +
                ", withdrawYn='" + withdrawYn + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getStockFirm() {
        return stockFirm;
    }

    public void setStockFirm(String stockFirm) {
        this.stockFirm = stockFirm;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public Date getAppKeyExpiresin() {
        return appKeyExpiresin;
    }

    public void setAppKeyExpiresin(Date appKeyExpiresin) {
        this.appKeyExpiresin = appKeyExpiresin;
    }

    public String getTermsAgreementYn() {
        return termsAgreementYn;
    }

    public void setTermsAgreementYn(String termsAgreementYn) {
        this.termsAgreementYn = termsAgreementYn;
    }

    public int getReportCount() {
        return reportCount;
    }

    public void setReportCount(int reportCount) {
        this.reportCount = reportCount;
    }

    public String getBlacklistYn() {
        return blacklistYn;
    }

    public void setBlacklistYn(String blacklistYn) {
        this.blacklistYn = blacklistYn;
    }

    public String getStockCareer() {
        return stockCareer;
    }

    public String getWithdrawYn() {
        return withdrawYn;
    }

    public void setStockCareer(String stockCareer) {
        this.stockCareer = stockCareer;
    }

    public void setWithdrawYn(String withdrawYn) {this.withdrawYn = withdrawYn;}

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {this.authorities = authorities;}
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
