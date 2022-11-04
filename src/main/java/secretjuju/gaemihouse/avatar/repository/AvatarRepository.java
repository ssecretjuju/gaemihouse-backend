package secretjuju.gaemihouse.avatar.repository;

import org.springframework.data.repository.Repository;
import secretjuju.gaemihouse.avatar.model.Avatar;

public interface AvatarRepository extends Repository<Avatar, Integer> {

    Avatar findAvatarByMemberCode(int memberCode);

    void save(Avatar avatar);

    void deleteByMemberCode(int memberCode);
}
