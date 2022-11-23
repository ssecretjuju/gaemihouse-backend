package secretjuju.gaemihouse.avatar.model;

import javax.persistence.*;

@Entity(name = "Avatar")
@Table(name="TBL_AVATAR")
@Access(AccessType.FIELD)
public class Avatar {

    @Id
    @Column(name = "MEMBER_ID")
    private String memberId;

    @Column(name = "FACE_TYPE")
    private int faceType;

    @Column(name = "BODY_TYPE")
    private int bodyType;

    @Column(name = "ACC_TYPE")
    private int accType;

    public Avatar() {
    }

    public Avatar(String memberId) {
        this.memberId = memberId;
    }

    public Avatar(String memberId, int faceType, int bodyType, int accType) {
        this.memberId = memberId;
        this.faceType = faceType;
        this.bodyType = bodyType;
        this.accType = accType;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getFaceType() {
        return faceType;
    }

    public int getBodyType() {
        return bodyType;
    }

    public int getAccType() {
        return accType;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "memberId='" + memberId + '\'' +
                ", faceType=" + faceType +
                ", bodyType=" + bodyType +
                ", accType=" + accType +
                '}';
    }
}
