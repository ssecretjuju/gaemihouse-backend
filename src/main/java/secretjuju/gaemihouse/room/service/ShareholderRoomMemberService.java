package secretjuju.gaemihouse.room.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import secretjuju.gaemihouse.account.service.KoreaInvestmentService;
import secretjuju.gaemihouse.room.model.ShareholderRoomMember;
import secretjuju.gaemihouse.room.dto.ShareholderRoomMemberDTO;
import secretjuju.gaemihouse.room.repository.ShareholderRoomMemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShareholderRoomMemberService {
    private final ShareholderRoomMemberRepository shareholderRoomMemberRepository;
    private final KoreaInvestmentService koreaInvestmentService;
    private final ModelMapper modelMapper;

    public ShareholderRoomMemberService(ShareholderRoomMemberRepository shareholderRoomMemberRepository, KoreaInvestmentService koreaInvestmentService, ModelMapper modelMapper) {
        this.shareholderRoomMemberRepository = shareholderRoomMemberRepository;
        this.koreaInvestmentService = koreaInvestmentService;
        this.modelMapper = modelMapper;
    }

    public ShareholderRoomMemberDTO findShareholderRoomMember(String memberId) {

        ShareholderRoomMember shareholderRoomMember = shareholderRoomMemberRepository.findByMemberId(memberId);

        return modelMapper.map(shareholderRoomMember, ShareholderRoomMemberDTO.class);
    }

    @Transactional
    public void updateShareholderRoom(ShareholderRoomMember shareholderRoomMember) {
        shareholderRoomMemberRepository.save(shareholderRoomMember);
    }

    public List<ShareholderRoomMemberDTO> findShareholderRoomMemberAllByRoomTitle(String roomTitle) {
        List<ShareholderRoomMember> shareholderRoomMembers = shareholderRoomMemberRepository.findAllByRoomTitle(roomTitle);
        List<ShareholderRoomMemberDTO> shareholderRoomMemberDTOS = new ArrayList<>();


        ShareholderRoomMember shareholderRoomMember = null;
        for(int i = 0; i < shareholderRoomMembers.size(); i++) {
            String roomMemberId = shareholderRoomMembers.get(i).getMemberId();
            int currentEvaluateProperty = koreaInvestmentService.getCurrentEvaluateProperty(roomMemberId);
            int joinEvaluateProperty = findShareholderRoomMember(roomMemberId).getJoinEvaluateProperty();

            double currentMemberYield = Math.round((currentEvaluateProperty - joinEvaluateProperty) / (double) joinEvaluateProperty * 100 * 100) / 100.0;

            shareholderRoomMember = new ShareholderRoomMember(shareholderRoomMembers.get(i).getRoomMemberCode(), currentMemberYield, joinEvaluateProperty, roomMemberId, roomTitle);

            updateShareholderRoom(shareholderRoomMember);
            shareholderRoomMemberDTOS.add(modelMapper.map(shareholderRoomMembers.get(i), ShareholderRoomMemberDTO.class));
        }

        return shareholderRoomMemberDTOS;
    }

    public double findShareholderRoomYieldByRoomCode(String memberId, String roomTitle) {
        List<ShareholderRoomMemberDTO> shareholderRoomMemberDTOS = findShareholderRoomMemberAllByRoomTitle(roomTitle);

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
