package secretjuju.gaemihouse.avatar.model;

import javax.persistence.*;

@Entity(name = "Avatar")
@Table(name="TBL_AVATAR")
@Access(AccessType.FIELD)
public class Avatar {

    @Id
    @Column(name = "AVATAR_ID")
    private int avatarId;

    @Column(name = "MEMBER_CODE")
    private int memberCode;

    public Avatar() {
    }

    public Avatar(int avatarId, int memberCode) {
        this.avatarId = avatarId;
        this.memberCode = memberCode;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public int getMemberCode() {
        return memberCode;
    }

}
