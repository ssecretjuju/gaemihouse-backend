package secretjuju.gaemihouse.avatar.service;

import org.apache.ibatis.javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public AvatarDTO selectAvatarByMemberNickname(String memberNickname) {

        Avatar avatar = avatarRepository.findAvatarByColorMemberNickname(memberNickname);

        return modelMapper.map(avatar, AvatarDTO.class);
    }

    @Transactional
    public boolean insertAvatarByColorMemberNickname(Avatar avatar) {

        try {
            avatarRepository.findAvatarByColorMemberNickname(avatar.getColorMemberNickname()).getFaceType(); // 이미 있는지 확인
            System.out.println("Already exists avatar");

            // 아바타가 이미 존재할 시 false 반환
            return false;
        } catch(NullPointerException e) {
            System.out.println(avatar);
            avatarRepository.save(avatar);
            System.out.println("Successful inserted");

            // 아바타가 존재하지 않을 시 true 반환
            return true;
        }

    }

    @Transactional
    public boolean updateAvatarByMemberNickname(Avatar avatar) {

        try {
            Avatar beforeAvatar = avatarRepository.findAvatarByColorMemberNickname(avatar.getColorMemberNickname());
            if(beforeAvatar.getColorMemberNickname().equals(avatar.getColorMemberNickname())) {

                avatarRepository.save(avatar);
                System.out.println("Update avatar");

                // 아바타 수정 시 true 반환
                return true;
            } else {
                System.out.println("Fail to update avatar");
                return false;
            }

        } catch(NullPointerException e) {
            System.out.println("Fail to update avatar");

            // 아바타가 존재하지 않을 시 false 반환
            return false;
        }

    }

    @Transactional
    public boolean deleteAvatarByMemberCode(Avatar avatar) {

        try {
            avatarRepository.deleteByColorMemberNickname(avatar.getColorMemberNickname());
            System.out.println("delete successfully");

            // 아바타를 삭제할 시 true 반환
            return true;
        } catch(NullPointerException e) {
            System.out.println("delete failed");

            // 아바타 삭제 실패 시 false 반환
            return false;
        }

    }
}
