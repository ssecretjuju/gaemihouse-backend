package secretjuju.gaemihouse.shareholder_room.repository;

import org.springframework.data.repository.Repository;
import secretjuju.gaemihouse.shareholder_room.model.ShareholderRoom;

public interface ShareholderRoomRepository extends Repository<ShareholderRoom, Integer> {

    ShareholderRoom findShareholderRoomByMapCode(int mapCode);

}
