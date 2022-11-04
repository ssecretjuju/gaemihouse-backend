package secretjuju.gaemihouse.shareholder_room.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "ShareholderRoom")
@Table(name="TBL_SHAREHOLDER_ROOM")
@Access(AccessType.FIELD)
public class ShareholderRoom {

    @Id
    @Column(name = "ROOM_CODE")
    private int roomCode;

    @Column(name = "ROOM_LIMITED_NUMBER")
    private int roomLimitedNumber;

    @Column(name = "ROOM_REGISTED_NUMBER")
    private int roomRegistedNumber;

    @Column(name = "ROOM_YIELD")
    private int roomYield;

    @Column(name = "MAP_CODE")
    private  int mapCode;

    public ShareholderRoom() {
    }

    public ShareholderRoom(int roomCode, int roomLimitedNumber, int roomRegistedNumber, int roomYield, int mapCode) {
        this.roomCode = roomCode;
        this.roomLimitedNumber = roomLimitedNumber;
        this.roomRegistedNumber = roomRegistedNumber;
        this.roomYield = roomYield;
        this.mapCode = mapCode;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public int getRoomLimitedNumber() {
        return roomLimitedNumber;
    }

    public int getRoomRegistedNumber() {
        return roomRegistedNumber;
    }

    public int getRoomYield() {
        return roomYield;
    }

    public int getMapCode() {
        return mapCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShareholderRoom that = (ShareholderRoom) o;
        return roomCode == that.roomCode && roomLimitedNumber == that.roomLimitedNumber && roomRegistedNumber == that.roomRegistedNumber && roomYield == that.roomYield && mapCode == that.mapCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomCode, roomLimitedNumber, roomRegistedNumber, roomYield, mapCode);
    }
}
