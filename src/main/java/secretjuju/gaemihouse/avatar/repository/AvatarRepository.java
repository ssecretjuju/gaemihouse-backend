package secretjuju.gaemihouse.avatar.repository;

import org.springframework.data.repository.Repository;
import secretjuju.gaemihouse.avatar.model.Avatar;

public interface AvatarRepository extends Repository<Avatar, Integer> {

    Avatar findAvatarByMemberId(String memberId);

    void save(Avatar avatar);

    void deleteByMemberId(String memberId);
}
