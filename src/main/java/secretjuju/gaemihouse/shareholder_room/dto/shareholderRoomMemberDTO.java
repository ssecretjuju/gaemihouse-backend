package secretjuju.gaemihouse.shareholder_room.dto;

import javax.persistence.Column;

public class shareholderRoomMemberDTO {

    private int roomMemberCode;
    private int roomMemberYield;
    private int joinEvaluateProperty;
    private int memberCode;
    private int roomCode;
    public shareholderRoomMemberDTO() {
    }

    public shareholderRoomMemberDTO(int roomMemberCode, int roomMemberYield, int joinEvaluateProperty, int memberCode, int roomCode) {
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

    public int getRoomMemberYield() {
        return roomMemberYield;
    }

    public void setRoomMemberYield(int roomMemberYield) {
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
        return "shareholderRoomMemberDTO{" +
                "roomMemberCode=" + roomMemberCode +
                ", roomMemberYield=" + roomMemberYield +
                ", joinEvaluateProperty=" + joinEvaluateProperty +
                ", memberCode=" + memberCode +
                ", roomCode=" + roomCode +
                '}';
    }
}
