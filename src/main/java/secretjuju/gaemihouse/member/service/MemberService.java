package secretjuju.gaemihouse.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import secretjuju.gaemihouse.member.dao.MemberMapper;
import secretjuju.gaemihouse.member.dto.MemberDTO;

/**
 * <pre>
 * Class : MemberService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-24       차용준            최초 생성
 * </pre>
 *
 * @author 차용준 (최초 작성자)
 * @version 1(클래스 버전)
 */
@Service
public class MemberService {
    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public MemberDTO selectMyInfo(String memberId) {
        log.info("[MemberService] getMyInfo Start ==============================");

        MemberDTO member = memberMapper.selectByMemberId(memberId);
        log.info("[MemberService] {}", member);
        log.info("[MemberService] getMyInfo End ==============================");

        return member;
    }


    public Object updateMember(MemberDTO memberDTO) {
        int updateMember = memberMapper.updateMember(memberDTO);
        return (updateMember > 0) ? "회원 정보 수정 성공 !" : "회원 정보 수정 실패 ㅜ";
    }

    public Object withdrawMember(MemberDTO memberDTO) {
        int withdrawMember = memberMapper.withdrawMember(memberDTO);
        return (withdrawMember > 0) ? "회원 탈퇴 성공 !" : "회원 탈퇴 실패 ㅜ";
    }

    public MemberDTO selectMemberInfobyCode(int memberCode) {
        MemberDTO member = memberMapper.selectMemberInfobyCode(memberCode);
        return member;
    }

    public MemberDTO selectMemberInfoByMemberNickname(String memberNickname) {
        MemberDTO member = memberMapper.selectMemberInfoByMemberNickname(memberNickname);
        return member;
    }
}
