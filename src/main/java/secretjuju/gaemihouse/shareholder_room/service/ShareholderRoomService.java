package secretjuju.gaemihouse.shareholder_room.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import secretjuju.gaemihouse.avatar.dto.AvatarDTO;
import secretjuju.gaemihouse.avatar.repository.AvatarRepository;
import secretjuju.gaemihouse.shareholder_room.dto.ShareholderRoomDTO;
import secretjuju.gaemihouse.shareholder_room.model.ShareholderRoom;
import secretjuju.gaemihouse.shareholder_room.repository.ShareholderRoomRepository;

@Service
public class ShareholderRoomService {

    private final ShareholderRoomRepository shareholderRoomRepository;
    private final ModelMapper modelMapper;

    public ShareholderRoomService(ShareholderRoomRepository shareholderRoomRepository, ModelMapper modelMapper) {
        this.shareholderRoomRepository =shareholderRoomRepository;
        this.modelMapper = modelMapper;
    }

    public ShareholderRoomDTO selectShareholderRoomByMapCode(int internalMapCode) {

        ShareholderRoom shareholderRoom = shareholderRoomRepository.findShareholderRoomByMapCode(internalMapCode);

        return modelMapper.map(shareholderRoom, ShareholderRoomDTO.class);
    }
}
