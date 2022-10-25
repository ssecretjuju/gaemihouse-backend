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

        return mapper.findByMemberId(memberId)
                .map(user -> addAuthorities(user))
                .orElseThrow(() -> new UserNotFoundException(memberId + "> 찾을 수 없습니다."));
    }

    private MemberDTO addAuthorities(MemberDTO member) {
        member.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(member.getMemberRole())));

        return member;
    }

}