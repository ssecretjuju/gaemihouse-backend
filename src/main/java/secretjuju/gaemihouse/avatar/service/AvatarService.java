package secretjuju.gaemihouse.avatar.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import secretjuju.gaemihouse.avatar.dto.AvatarDTO;
import secretjuju.gaemihouse.avatar.model.Avatar;
import secretjuju.gaemihouse.avatar.repository.AvatarRepository;

import java.util.Optional;

@Service
public class AvatarService {

    private final AvatarRepository avatarRepository;
    private final ModelMapper modelMapper;

    public AvatarService(AvatarRepository avatarRepository, ModelMapper modelMapper) {
        this.avatarRepository = avatarRepository;
        this.modelMapper = modelMapper;
    }
    public AvatarDTO selectAvatarByMemberCode(int memberCode) {

        Avatar avatar = avatarRepository.findAvatarByMemberCode(memberCode);

        return modelMapper.map(avatar, AvatarDTO.class);
    }
}
