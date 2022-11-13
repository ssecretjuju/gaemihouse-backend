package secretjuju.gaemihouse.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import secretjuju.gaemihouse.room.model.ShareholderRoomMember;

import java.util.List;

public interface ShareholderRoomMemberRepository extends JpaRepository<ShareholderRoomMember, Integer> {
    ShareholderRoomMember findByMemberCode(int memberCode);

    List<ShareholderRoomMember> findAllByRoomCode(int roomCode);
}
