package secretjuju.gaemihouse.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.member.dto.MemberDTO;
import secretjuju.gaemihouse.member.service.MemberService;
import secretjuju.gaemihouse.notice.dto.NoticeDTO;

/**
 * <pre>
 * Class : MemberController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-24       홍길동           최초 생성
 * </pre>
 *
 * @author 홍길동(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
@Controller
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<ResponseDTO> selectMyMemberInfo(@PathVariable String memberId) {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 조회 성공", memberService.selectMyInfo(memberId)));
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updateMember(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"회원 정보 수정 성공", memberService.updateMember(memberDTO)));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<ResponseDTO> withdrawMember(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"회원 정보 수정 성공", memberService.withdrawMember(memberDTO)));
    }

}
