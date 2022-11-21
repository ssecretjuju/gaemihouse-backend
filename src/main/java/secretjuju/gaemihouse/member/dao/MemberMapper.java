package secretjuju.gaemihouse.member.dao;

import org.apache.ibatis.annotations.Mapper;
import secretjuju.gaemihouse.member.dto.MemberDTO;

import java.util.Optional;

/**
 * <pre>
 * Class : MemberMapper
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-24       차용준           최초 생성
 * </pre>
 *
 * @author 차용준(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
@Mapper
public interface MemberMapper {

    MemberDTO selectById(String id);

    int insertMember(MemberDTO member);

    Optional<MemberDTO> findByMemberId(String memberId);

    MemberDTO selectByMemberId(String memberId);

    int updateMember(MemberDTO memberDTO);

    int withdrawMember(MemberDTO memberDTO);

    MemberDTO selectMemberInfobyCode(int memberCode);

    MemberDTO selectMyInfo(String memberId);
}
