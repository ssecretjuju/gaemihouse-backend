package secretjuju.gaemihouse.shareholder_room.repository;

import org.springframework.data.repository.Repository;
import secretjuju.gaemihouse.shareholder_room.model.ShareholderRoom;

import java.util.List;

public interface ShareholderRoomRepository extends Repository<ShareholderRoom, Integer> {

   List<ShareholderRoom> findShareholderRoomByMapCode(int mapCode);


}
