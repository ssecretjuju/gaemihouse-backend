package secretjuju.gaemihouse.roomboard.dto;

import java.util.Date;

/**
 * <pre>
 * Class : RoomBoardDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-21       차용준           최초 생성
 * </pre>
 *
 * @author 차용준(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
public class RoomBoardDTO {
    private int roomBoardCode;
    private String roomBoardTitle;
    private String roomBoardContent;
    private Date roomBoardRegistDate;
    private int memberCode;
    private int shareholderRoomCode;
    private int likeCount;

    public RoomBoardDTO() {}

    public RoomBoardDTO(int roomBoardCode, String roomBoardTitle, String roomBoardContent,
                        Date roomBoardRegistDate, int memberCode, int shareholderRoomCode, int likeCount) {
        this.roomBoardCode = roomBoardCode;
        this.roomBoardTitle = roomBoardTitle;
        this.roomBoardContent = roomBoardContent;
        this.roomBoardRegistDate = roomBoardRegistDate;
        this.memberCode = memberCode;
        this.shareholderRoomCode = shareholderRoomCode;
        this.likeCount = likeCount;
    }

    @Override
    public String toString() {
        return "RoomBoardDTO{" +
                "roomBoardCode=" + roomBoardCode +
                ", roomBoardTitle='" + roomBoardTitle + '\'' +
                ", roomBoardContent='" + roomBoardContent + '\'' +
                ", roomBoardRegistDate=" + roomBoardRegistDate +
                ", memberCode=" + memberCode +
                ", shareholderRoomCode=" + shareholderRoomCode +
                ", likeCount=" + likeCount +
                '}';
    }

    public int getRoomBoardCode() {
        return roomBoardCode;
    }

    public void setRoomBoardCode(int roomBoardCode) {
        this.roomBoardCode = roomBoardCode;
    }

    public String getRoomBoardTitle() {
        return roomBoardTitle;
    }

    public void setRoomBoardTitle(String roomBoardTitle) {
        this.roomBoardTitle = roomBoardTitle;
    }

    public String getRoomBoardContent() {
        return roomBoardContent;
    }

    public void setRoomBoardContent(String roomBoardContent) {
        this.roomBoardContent = roomBoardContent;
    }

    public Date getRoomBoardRegistDate() {
        return roomBoardRegistDate;
    }

    public void setRoomBoardRegistDate(Date roomBoardRegistDate) {
        this.roomBoardRegistDate = roomBoardRegistDate;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public int getShareholderRoomCode() {
        return shareholderRoomCode;
    }

    public void setShareholderRoomCode(int shareholderRoomCode) {
        this.shareholderRoomCode = shareholderRoomCode;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}