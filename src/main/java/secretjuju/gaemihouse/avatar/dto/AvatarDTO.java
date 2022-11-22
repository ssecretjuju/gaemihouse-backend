package secretjuju.gaemihouse.avatar.dto;

public class AvatarDTO {
    private int avatarId;
    private int memberCode;

    public AvatarDTO() {
    }

    public AvatarDTO(int avatarId, int memberCode) {
        this.avatarId = avatarId;
        this.memberCode = memberCode;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    @Override
    public String toString() {
        return "AvatarDTO{" +
                "avatarId=" + avatarId +
                ", memberCode=" + memberCode +
                '}';
    }
}
