package secretjuju.gaemihouse.shareholder_room.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import secretjuju.gaemihouse.shareholder_room.model.ShareholderRoomMember;
import secretjuju.gaemihouse.shareholder_room.dto.ShareholderRoomMemberDTO;
import secretjuju.gaemihouse.shareholder_room.repository.ShareholderRoomMemberRepository;

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

}
