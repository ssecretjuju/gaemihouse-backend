package secretjuju.gaemihouse.room.dto;

public class ShareholderRoomMemberDTO {

    private int roomMemberCode;
    private double roomMemberYield;
    private int joinEvaluateProperty;
    private String memberId;
    private String roomTitle;
    public ShareholderRoomMemberDTO() {
    }

    public ShareholderRoomMemberDTO(int roomMemberCode, double roomMemberYield, int joinEvaluateProperty, String memberId, String roomTitle) {
        this.roomMemberCode = roomMemberCode;
        this.roomMemberYield = roomMemberYield;
        this.joinEvaluateProperty = joinEvaluateProperty;
        this.memberId = memberId;
        this.roomTitle = roomTitle;
    }

    public int getRoomMemberCode() {
        return roomMemberCode;
    }

    public void setRoomMemberCode(int roomMemberCode) {
        this.roomMemberCode = roomMemberCode;
    }

    public double getRoomMemberYield() {
        return roomMemberYield;
    }

    public void setRoomMemberYield(double roomMemberYield) {
        this.roomMemberYield = roomMemberYield;
    }

    public int getJoinEvaluateProperty() {
        return joinEvaluateProperty;
    }

    public void setJoinEvaluateProperty(int joinEvaluateProperty) {
        this.joinEvaluateProperty = joinEvaluateProperty;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    @Override
    public String toString() {
        return "ShareholderRoomMemberDTO{" +
                "roomMemberCode=" + roomMemberCode +
                ", roomMemberYield=" + roomMemberYield +
                ", joinEvaluateProperty=" + joinEvaluateProperty +
                ", memberId='" + memberId + '\'' +
                ", roomTitle='" + roomTitle + '\'' +
                '}';
    }
}
