package secretjuju.gaemihouse.world.dto;

/**
 * <pre>
 * Class : CommunityDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-04       홍길동           최초 생성
 * </pre>
 *
 * @author 홍길동(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
public class WorldDTO {

    private int worldId;

    public WorldDTO () {}

    public WorldDTO(int worldId) {
        this.worldId = worldId;
    }

    @Override
    public String toString() {
        return "WorldDTO{" +
                "worldId=" + worldId +
                '}';
    }

    public int getWorldId() {
        return worldId;
    }

    public void setWorldId(int worldId) {
        this.worldId = worldId;
    }
}
