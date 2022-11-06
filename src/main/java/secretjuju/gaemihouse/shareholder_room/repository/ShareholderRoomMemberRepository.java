package secretjuju.gaemihouse.shareholder_room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import secretjuju.gaemihouse.shareholder_room.model.ShareholderRoomMember;

public interface ShareholderRoomMemberRepository extends JpaRepository<ShareholderRoomMember, Integer> {
    ShareholderRoomMember findByMemberCode(int memberCode);
}
