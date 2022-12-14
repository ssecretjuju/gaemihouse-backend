package secretjuju.gaemihouse.room.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "주주방 정보", description = "방 아이디, 방 최대 인원, 방 등록 인원, 방 수익률, 맵 아이디")
public class ShareholderRoomDTO {

    @ApiModelProperty(value = "방 아이디")
    private int roomCode;
    @ApiModelProperty(value = "방 제목")
    private String roomTitle;
    @ApiModelProperty(value = "방 최대 인원")
    private int roomLimitedNumber;
    @ApiModelProperty(value = "방 등록 인원")
    private int roomRegistedNumber;
    @ApiModelProperty(value = "방 수익률")
    private double roomYield;

    @ApiModelProperty(value = "방장 아이디")
    private String memberId;

    public ShareholderRoomDTO() {
    }

    public ShareholderRoomDTO(int roomCode, String roomTitle, int roomLimitedNumber, int roomRegistedNumber, double roomYield, String memberId) {
        this.roomCode = roomCode;
        this.roomTitle = roomTitle;
        this.roomLimitedNumber = roomLimitedNumber;
        this.roomRegistedNumber = roomRegistedNumber;
        this.roomYield = roomYield;
        this.memberId = memberId;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
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

    public double getRoomYield() {
        return roomYield;
    }

    public void setRoomYield(double roomYield) {
        this.roomYield = roomYield;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "ShareholderRoomDTO{" +
                "roomCode=" + roomCode +
                ", roomTitle='" + roomTitle + '\'' +
                ", roomLimitedNumber=" + roomLimitedNumber +
                ", roomRegistedNumber=" + roomRegistedNumber +
                ", roomYield=" + roomYield +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
