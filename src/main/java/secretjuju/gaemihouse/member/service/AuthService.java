package secretjuju.gaemihouse.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import secretjuju.gaemihouse.exception.DuplicatedUsernameException;
import secretjuju.gaemihouse.exception.LoginFailedException;
import secretjuju.gaemihouse.jwt.TokenProvider;
import secretjuju.gaemihouse.member.dao.MemberMapper;
import secretjuju.gaemihouse.member.dto.MemberDTO;
import secretjuju.gaemihouse.member.dto.TokenDTO;



@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public AuthService(MemberMapper memberMapper, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @Transactional
    public MemberDTO signup(MemberDTO MemberDTO) {
        log.info("[AuthService] Signup Start ===================================");
        log.info("[AuthService] MemberRequestDto {}", MemberDTO);

        if(memberMapper.selectById(MemberDTO.getMemberId()) != null) {
            log.info("[AuthService] 아이디가 중복됩니다.");
            throw new DuplicatedUsernameException("아이디가 중복됩니다.");
        }

        log.info("[AuthService] Member Signup Start ==============================");
        MemberDTO.setMemberPassword(passwordEncoder.encode(MemberDTO.getMemberPassword()));
        log.info("[AuthService] Member {}", MemberDTO);

        //insert
        int result = memberMapper.insertMember(MemberDTO);
        log.info("[AuthService] Member Insert Result {}", result > 0 ? "회원 가입 성공" : "회원 가입 실패");

        log.info("[AuthService] Signup End ==============================");

        return MemberDTO;
    }

    @Transactional
    public TokenDTO login(MemberDTO MemberDTO) {
        log.info("[AuthService] Login Start ===================================");

        System.out.println("[AuthService] {} ! ! "+ MemberDTO);

        // 1. 아이디 조회
        //findByMemberId
        MemberDTO member = memberMapper.findByMemberId(MemberDTO.getMemberId())
                .orElseThrow(() -> new LoginFailedException("잘못된 아이디 또는 비밀번호입니다"));

        // 2. 비밀번호 매칭
        if (!passwordEncoder.matches(MemberDTO.getMemberPassword(), member.getMemberPassword())) {
            log.info("[AuthService] Password Match Fail!!!!!!!!!!!!");
            throw new LoginFailedException("잘못된 아이디 또는 비밀번호입니다");
        }

        // 3. 토큰 발급
        TokenDTO tokenDTO = tokenProvider.generateTokenDTO(member);
        System.out.println("[AuthService] TokenDTO {} ! ! " + tokenDTO);

        log.info("[AuthService] Login End ===================================");

        return tokenDTO;
    }
}
