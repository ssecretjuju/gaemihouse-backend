package secretjuju.gaemihouse.avatar.model;

import javax.persistence.*;

@Entity(name = "Avatar")
@Table(name="TBL_AVATAR")
@Access(AccessType.FIELD)
public class Avatar {

    @Id
    @Column(name = "COLOR_MEMBER_NICKNAME")
    private String colorMemberNickname;

    @Column(name = "FACE_TYPE")
    private int faceType;

    @Column(name = "BODY_TYPE")
    private int bodyType;

    @Column(name = "ACC_TYPE")
    private int accType;

    public Avatar() {
    }

    public Avatar(String colorMemberNickname) {
        this.colorMemberNickname = colorMemberNickname;
    }

    public Avatar(String colorMemberNickname, int faceType, int bodyType, int accType) {
        this.colorMemberNickname = colorMemberNickname;
        this.faceType = faceType;
        this.bodyType = bodyType;
        this.accType = accType;
    }

    public String getColorMemberNickname() {
        return colorMemberNickname;
    }

    public void setColorMemberNickname(String colorMemberNickname) {
        this.colorMemberNickname = colorMemberNickname;
    }

    public int getFaceType() {
        return faceType;
    }

    public void setFaceType(int faceType) {
        this.faceType = faceType;
    }

    public int getBodyType() {
        return bodyType;
    }

    public void setBodyType(int bodyType) {
        this.bodyType = bodyType;
    }

    public int getAccType() {
        return accType;
    }

    public void setAccType(int accType) {
        this.accType = accType;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "colorMemberNickname='" + colorMemberNickname + '\'' +
                ", faceType=" + faceType +
                ", bodyType=" + bodyType +
                ", accType=" + accType +
                '}';
    }
}
