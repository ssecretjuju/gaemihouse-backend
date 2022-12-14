package secretjuju.gaemihouse.roomboard.dto;

/**
 * <pre>
 * Class : LikeCountDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-22       차용준           최초 생성
 * </pre>
 *
 * @author 차용준(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
public class LikeCountDTO {
    private int roomboardCode;
    private int memberCode;
    private int pushMemberCode;
    private String pushedYn;

    public LikeCountDTO() {}

    public LikeCountDTO(int roomboardCode, int memberCode, int pushMemberCode, String pushedYn) {
        this.roomboardCode = roomboardCode;
        this.memberCode = memberCode;
        this.pushMemberCode = pushMemberCode;
        this.pushedYn = pushedYn;
    }

    @Override
    public String toString() {
        return "LikeCountDTO{" +
                "roomboardCode=" + roomboardCode +
                ", memberCode=" + memberCode +
                ", pushMemberCode=" + pushMemberCode +
                ", pushedYn='" + pushedYn + '\'' +
                '}';
    }

    public int getRoomboardCode() {
        return roomboardCode;
    }

    public void setRoomboardCode(int roomboardCode) {
        this.roomboardCode = roomboardCode;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public int getPushMemberCode() {
        return pushMemberCode;
    }

    public void setPushMemberCode(int pushMemberCode) {
        this.pushMemberCode = pushMemberCode;
    }

    public String getPushedYn() {
        return pushedYn;
    }

    public void setPushedYn(String pushedYn) {
        this.pushedYn = pushedYn;
    }
}
