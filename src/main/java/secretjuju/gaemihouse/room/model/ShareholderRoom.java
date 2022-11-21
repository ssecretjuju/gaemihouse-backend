package secretjuju.gaemihouse.room.model;

import javax.persistence.*;

@Entity(name = "ShareholderRoom")
@Table(name="TBL_SHAREHOLDER_ROOM")
@Access(AccessType.FIELD)
@SequenceGenerator(
        name="SEQ_ROOM_CODE_GEN",
        sequenceName = "SEQ_ROOM_CODE",
        initialValue = 1,
        allocationSize = 1
)
public class ShareholderRoom {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ROOM_CODE_GEN"
    )
    @Column(name = "ROOM_CODE")
    private int roomCode;

    @Column(name = "ROOM_TITLE")
    private String roomTitle;

    @Column(name = "ROOM_LIMITED_NUMBER")
    private int roomLimitedNumber;

    @Column(name = "ROOM_REGISTED_NUMBER")
    private int roomRegistedNumber;

    @Column(name = "ROOM_YIELD")
    private int roomYield;

//    @Column(name = "MAP_CODE")
//    private  int mapCode;


    public ShareholderRoom() {
    }

    public ShareholderRoom(String roomTitle, int roomLimitedNumber, int roomRegistedNumber, int roomYield) {
        this.roomTitle = roomTitle;
        this.roomLimitedNumber = roomLimitedNumber;
        this.roomRegistedNumber = roomRegistedNumber;
        this.roomYield = roomYield;
    }

    public ShareholderRoom(int roomCode, String roomTitle, int roomLimitedNumber, int roomRegistedNumber, int roomYield) {
        this.roomCode = roomCode;
        this.roomTitle = roomTitle;
        this.roomLimitedNumber = roomLimitedNumber;
        this.roomRegistedNumber = roomRegistedNumber;
        this.roomYield = roomYield;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public String getRoomTitle() {
        return roomTitle;
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
}
