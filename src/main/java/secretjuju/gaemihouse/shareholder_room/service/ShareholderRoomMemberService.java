package secretjuju.gaemihouse.shareholder_room.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import secretjuju.gaemihouse.shareholder_room.model.ShareholderRoomMember;
import secretjuju.gaemihouse.shareholder_room.repository.ShareholderRoomMemberRepository;

@Service
public class ShareholderRoomMemberService {

    private final ShareholderRoomMemberRepository shareholderRoomMemberRepository;

    public ShareholderRoomMemberService(ShareholderRoomMemberRepository shareholderRoomMemberRepository) {
        this.shareholderRoomMemberRepository = shareholderRoomMemberRepository;
    }

    @Transactional
    public void joinShareHolderRoom(ShareholderRoomMember shareholderRoomMember) {
        shareholderRoomMemberRepository.save(shareholderRoomMember);
    }
}
