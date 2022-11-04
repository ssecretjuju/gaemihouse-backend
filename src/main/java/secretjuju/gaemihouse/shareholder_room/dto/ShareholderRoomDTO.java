package secretjuju.gaemihouse.shareholder_room.dto;

import javax.persistence.Column;

public class ShareholderRoomDTO {

    private int roomCode;
    private int roomLimitedNumber;
    private int roomRegistedNumber;
    private int roomYield;
    private  int mapCode;

    public ShareholderRoomDTO() {
    }

    public ShareholderRoomDTO(int roomCode, int roomLimitedNumber, int roomRegistedNumber, int roomYield, int mapCode) {
        this.roomCode = roomCode;
        this.roomLimitedNumber = roomLimitedNumber;
        this.roomRegistedNumber = roomRegistedNumber;
        this.roomYield = roomYield;
        this.mapCode = mapCode;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }

    public int getRoomLimitedNumber() {
        return roomLimitedNumber;
    }

    public void setRoomLimitedNumber(int roomLimitedNumber) {
        this.roomLimitedNumber = roomLimitedNumber;
    }

    public int getRoomRegistedNumber() {
        return roomRegistedNumber;
    }

    public void setRoomRegistedNumber(int roomRegistedNumber) {
        this.roomRegistedNumber = roomRegistedNumber;
    }

    public int getRoomYield() {
        return roomYield;
    }

    public void setRoomYield(int roomYield) {
        this.roomYield = roomYield;
    }

    public int getMapCode() {
        return mapCode;
    }

    public void setMapCode(int mapCode) {
        this.mapCode = mapCode;
    }

    @Override
    public String toString() {
        return "ShareholderRoomDTO{" +
                "roomCode=" + roomCode +
                ", roomLimitedNumber=" + roomLimitedNumber +
                ", roomRegistedNumber=" + roomRegistedNumber +
                ", roomYield=" + roomYield +
                ", mapCode=" + mapCode +
                '}';
    }
}
