package secretjuju.gaemihouse.avatar.dto;

public class AvatarDTO {
    private String colorMemberNickname;
    private int faceType;
    private int bodyType;

    private int accType;

    public AvatarDTO() {
    }

    public AvatarDTO(String colorMemberNickname, int faceType, int bodyType, int accType) {
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
        return "AvatarDTO{" +
                "colorMemberNickname='" + colorMemberNickname + '\'' +
                ", faceType=" + faceType +
                ", bodyType=" + bodyType +
                ", accType=" + accType +
                '}';
    }
}
