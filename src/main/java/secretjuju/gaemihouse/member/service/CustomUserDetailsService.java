package secretjuju.gaemihouse.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import secretjuju.gaemihouse.exception.UserNotFoundException;
import secretjuju.gaemihouse.member.dao.MemberMapper;
import secretjuju.gaemihouse.member.dto.MemberDTO;

import java.util.Arrays;
/**
 * <pre>
 * Class : CustomUserDetailsService
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
 * @see (참고할 class 또는 외부 url)
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);
    private final MemberMapper mapper;

    public CustomUserDetailsService(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        log.info("[CustomUserDetailsService] ===================================");
        log.info("[CustomUserDetailsService] loadUserByUsername {}", memberId);

        System.out.println("UserDetails에 대한 설정을 진행 @ @ @");

        return mapper.findByMemberId(memberId)
                .map(user -> addAuthorities(user))
                .orElseThrow(() -> new UserNotFoundException(memberId + "> 찾을 수 없습니다."));
    }

    private MemberDTO addAuthorities(MemberDTO member) {
        member.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(member.getMemberRole())));

        return member;
    }

}