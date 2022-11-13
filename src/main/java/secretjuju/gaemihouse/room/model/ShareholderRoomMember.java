package secretjuju.gaemihouse.room.model;

import javax.persistence.*;

@Entity(name = "ShareholderRoomMember")
@Table(name="TBL_SHAREHOLDER_ROOM_MEMBER")
@Access(AccessType.FIELD)
@SequenceGenerator(
        name="SEQ_ROOM_MEMBER_CODE_GEN",
        sequenceName = "SEQ_ROOM_MEMBER_CODE",
        initialValue = 1,
        allocationSize = 1
)
public class ShareholderRoomMember {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ROOM_MEMBER_CODE_GEN"
    )
    @Column(name = "ROOM_MEMBER_CODE")
    private int roomMemberCode;

    @Column(name = "ROOM_MEMBER_YIELD")
    private double roomMemberYield;

    @Column(name = "JOIN_EVALUATE_PROPERTY")
    private int joinEvaluateProperty;

    @Column(name = "MEMBER_CODE")
    private int memberCode;

    @Column(name = "ROOM_CODE")
    private int roomCode;

    public ShareholderRoomMember() {
    }

    public ShareholderRoomMember(double roomMemberYield, int joinEvaluateProperty, int memberCode, int roomCode) {
        this.roomMemberYield = roomMemberYield;
        this.joinEvaluateProperty = joinEvaluateProperty;
        this.memberCode = memberCode;
        this.roomCode = roomCode;
    }

    public ShareholderRoomMember(int roomMemberCode, double roomMemberYield, int joinEvaluateProperty, int memberCode, int roomCode) {
        this.roomMemberCode = roomMemberCode;
        this.roomMemberYield = roomMemberYield;
        this.joinEvaluateProperty = joinEvaluateProperty;
        this.memberCode = memberCode;
        this.roomCode = roomCode;
    }

    public int getRoomMemberCode() {
        return roomMemberCode;
    }

    public double getRoomMemberYield() {
        return roomMemberYield;
    }

    public int getJoinEvaluateProperty() {
        return joinEvaluateProperty;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public int getRoomCode() {
        return roomCode;
    }
}
