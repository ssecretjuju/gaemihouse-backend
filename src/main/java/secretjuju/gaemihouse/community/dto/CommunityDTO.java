package secretjuju.gaemihouse.community.dto;

import java.util.Date;

/**
 * <pre>
 * Class : CommunityDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-04       차용준           최초 생성
 * </pre>
 *
 * @author 차용준(최초 작성자)
 * @version 1(클래스 버전)
 */
public class CommunityDTO {
    private int communityCode;
    private String communityTitle;
    private String communityContent; 
    private Date communityRegistDate;
    private int memberCode;
    private int shareholderRoomCode;
        
        public CommunityDTO() {}

    public CommunityDTO(int communityCode, String communityTitle, String communityContent,
                        Date communityRegistDate, int memberCode, int shareholderRoomCode) {
        this.communityCode = communityCode;
        this.communityTitle = communityTitle;
        this.communityContent = communityContent;
        this.communityRegistDate = communityRegistDate;
        this.memberCode = memberCode;
        this.shareholderRoomCode = shareholderRoomCode;
    }

    @Override
    public String toString() {
        return "CommunityDTO{" +
                "communityCode=" + communityCode +
                ", communityTitle='" + communityTitle + '\'' +
                ", communityContent='" + communityContent + '\'' +
                ", communityRegistDate=" + communityRegistDate +
                ", memberCode=" + memberCode +
                ", shareholderRoomCode=" + shareholderRoomCode +
                '}';
    }

    public int getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(int communityCode) {
        this.communityCode = communityCode;
    }

    public String getCommunityTitle() {
        return communityTitle;
    }

    public void setCommunityTitle(String communityTitle) {
        this.communityTitle = communityTitle;
    }

    public String getCommunityContent() {
        return communityContent;
    }

    public void setCommunityContent(String communityContent) {
        this.communityContent = communityContent;
    }

    public Date getCommunityRegistDate() {
        return communityRegistDate;
    }

    public void setCommunityRegistDate(Date communityRegistDate) {
        this.communityRegistDate = communityRegistDate;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public int getshareholderRoomCode() {
        return shareholderRoomCode;
    }

    public void setshareholderRoomCode(int shareholderRoomCode) {
        this.shareholderRoomCode = shareholderRoomCode;
    }
}
