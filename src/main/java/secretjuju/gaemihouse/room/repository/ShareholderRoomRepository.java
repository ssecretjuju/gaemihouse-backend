package secretjuju.gaemihouse.room.repository;

import org.springframework.data.repository.Repository;
import secretjuju.gaemihouse.room.model.ShareholderRoom;

import java.util.List;

public interface ShareholderRoomRepository extends Repository<ShareholderRoom, Integer> {

   List<ShareholderRoom> findShareholderRoomByMapCode(int mapCode);

   void save(ShareholderRoom shareholderRoom);

   void deleteByRoomCode(int roomCode);
}
