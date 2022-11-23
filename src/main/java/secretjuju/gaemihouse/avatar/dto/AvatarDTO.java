package secretjuju.gaemihouse.avatar.dto;

public class AvatarDTO {
    private String memberId;
    private int faceType;
    private int bodyType;

    private int accType;

    public AvatarDTO() {
    }

    public AvatarDTO(String memberId, int faceType, int bodyType, int accType) {
        this.memberId = memberId;
        this.faceType = faceType;
        this.bodyType = bodyType;
        this.accType = accType;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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
                "memberId='" + memberId + '\'' +
                ", faceType=" + faceType +
                ", bodyType=" + bodyType +
                ", accType=" + accType +
                '}';
    }
}
