package secretjuju.gaemihouse.room.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import secretjuju.gaemihouse.room.dto.ShareholderRoomDTO;
import secretjuju.gaemihouse.room.model.ShareholderRoom;
import secretjuju.gaemihouse.room.repository.ShareholderRoomRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShareholderRoomService {

    private final ShareholderRoomRepository shareholderRoomRepository;
    private final ModelMapper modelMapper;

    public ShareholderRoomService(ShareholderRoomRepository shareholderRoomRepository, ModelMapper modelMapper) {
        this.shareholderRoomRepository =shareholderRoomRepository;
        this.modelMapper = modelMapper;
    }

    public List<ShareholderRoomDTO> selectShareholderRoomByMapCode(int mapcode) {

        List<ShareholderRoom> shareholderRooms = shareholderRoomRepository.findShareholderRoomByMapCode(mapcode);
        List<ShareholderRoomDTO> shareholderRoomDTOS = new ArrayList<>();
        for (int i = 0; i < shareholderRooms.size(); i++) {
            shareholderRoomDTOS.add(modelMapper.map(shareholderRooms.get(i), ShareholderRoomDTO.class));
        }

        return shareholderRoomDTOS;
    }

    @Transactional
    public void insertShareholderRoom(ShareholderRoom shareholderRoom) {

        shareholderRoomRepository.save(shareholderRoom);
    }

    @Transactional
    public void deleteShareholderRoom(int roomCode) {

        shareholderRoomRepository.deleteByRoomCode(roomCode);
    }
}
