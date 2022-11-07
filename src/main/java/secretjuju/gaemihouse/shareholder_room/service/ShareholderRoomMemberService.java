package secretjuju.gaemihouse.shareholder_room.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import secretjuju.gaemihouse.shareholder_room.dto.ShareholderRoomDTO;
import secretjuju.gaemihouse.shareholder_room.model.ShareholderRoom;
import secretjuju.gaemihouse.shareholder_room.model.ShareholderRoomMember;
import secretjuju.gaemihouse.shareholder_room.dto.ShareholderRoomMemberDTO;
import secretjuju.gaemihouse.shareholder_room.repository.ShareholderRoomMemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShareholderRoomMemberService {

    private final ShareholderRoomMemberRepository shareholderRoomMemberRepository;
    private final ModelMapper modelMapper;

    public ShareholderRoomMemberService(ShareholderRoomMemberRepository shareholderRoomMemberRepository, ModelMapper modelMapper) {
        this.shareholderRoomMemberRepository = shareholderRoomMemberRepository;
        this.modelMapper = modelMapper;
    }

    public ShareholderRoomMemberDTO findShareholderRoomMember(int memberCode) {

        ShareholderRoomMember shareholderRoomMember = shareholderRoomMemberRepository.findByMemberCode(memberCode);

        return modelMapper.map(shareholderRoomMember, ShareholderRoomMemberDTO.class);
    }

    @Transactional
    public void updateShareholderRoom(ShareholderRoomMember shareholderRoomMember) {
        shareholderRoomMemberRepository.save(shareholderRoomMember);
    }

    public List<ShareholderRoomMemberDTO> findShareholderRoomMemberAllByRoomCode(int roomCode) {
        List<ShareholderRoomMember> shareholderRoomMembers = shareholderRoomMemberRepository.findAllByRoomCode(roomCode);
        List<ShareholderRoomMemberDTO> shareholderRoomMemberDTOS = new ArrayList<>();

        for(int i = 0; i < shareholderRoomMembers.size(); i++) {
            shareholderRoomMemberDTOS.add(modelMapper.map(shareholderRoomMembers.get(i), ShareholderRoomMemberDTO.class));
        }

        return shareholderRoomMemberDTOS;
    }

    public double findShareholderRoomYieldByRoomCode(int roomCode) {
        List<ShareholderRoomMemberDTO> shareholderRoomMemberDTOS = findShareholderRoomMemberAllByRoomCode(roomCode);

        int shareholderRoomStartProperty = 0;
        int shareholderRoomEndProperty = 0;
        int joinEvaluateProperty = 0;
        for(int i = 0; i < shareholderRoomMemberDTOS.size(); i++) {
            joinEvaluateProperty = shareholderRoomMemberDTOS.get(i).getJoinEvaluateProperty();
            shareholderRoomStartProperty += joinEvaluateProperty;
            shareholderRoomEndProperty += joinEvaluateProperty * (1 + shareholderRoomMemberDTOS.get(i).getRoomMemberYield() / 100.0);
        }

        return Math.round((shareholderRoomEndProperty - shareholderRoomStartProperty) / (double) shareholderRoomStartProperty * 100 * 100) / 100.0;
    }
}
