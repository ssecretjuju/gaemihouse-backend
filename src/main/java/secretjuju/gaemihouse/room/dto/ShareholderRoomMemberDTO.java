package secretjuju.gaemihouse.room.dto;

public class ShareholderRoomMemberDTO {

    private int roomMemberCode;
    private double roomMemberYield;
    private int joinEvaluateProperty;
    private int memberCode;
    private int roomCode;
    public ShareholderRoomMemberDTO() {
    }

    public ShareholderRoomMemberDTO(int roomMemberCode, double roomMemberYield, int joinEvaluateProperty, int memberCode, int roomCode) {
        this.roomMemberCode = roomMemberCode;
        this.roomMemberYield = roomMemberYield;
        this.joinEvaluateProperty = joinEvaluateProperty;
        this.memberCode = memberCode;
        this.roomCode = roomCode;
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

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }

    @Override
    public String toString() {
        return "ShareholderRoomMemberDTO{" +
                "roomMemberCode=" + roomMemberCode +
                ", roomMemberYield=" + roomMemberYield +
                ", joinEvaluateProperty=" + joinEvaluateProperty +
                ", memberCode=" + memberCode +
                ", roomCode=" + roomCode +
                '}';
    }
}
