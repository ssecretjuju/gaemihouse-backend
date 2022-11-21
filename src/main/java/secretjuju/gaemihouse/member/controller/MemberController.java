package secretjuju.gaemihouse.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import secretjuju.gaemihouse.account.service.KoreaInvestmentService;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.member.dto.MemberDTO;
import secretjuju.gaemihouse.member.service.MemberService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Class : MemberController
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
@Controller
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;
    private final KoreaInvestmentService koreaInvestmentService;

    public MemberController(MemberService memberService, KoreaInvestmentService koreaInvestmentService) {
        this.memberService = memberService;
        this.koreaInvestmentService = koreaInvestmentService;
    }

    @GetMapping("/id/{memberId}")
    public ResponseEntity<ResponseDTO> selectMyMemberInfo(@PathVariable String memberId) {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());

        double yield = koreaInvestmentService.getCurrentEvaluateYield(memberId);
        MemberDTO memberInfo = memberService.selectMyInfo(memberId);

        Map<String, Object> result = new HashMap<>();
        result.put("memberCode", memberInfo.getMemberCode());
        result.put("memberId", memberInfo.getMemberId());
        result.put("memberPassword", memberInfo.getMemberPassword());
        result.put("memberRole", memberInfo.getMemberRole());
        result.put("memberNickname", memberInfo.getMemberNickname());
        result.put("memberName", memberInfo.getMemberName());
        result.put("stockFirm", memberInfo.getStockFirm());
        result.put("accountNum", memberInfo.getAccountNum());
        result.put("appKey", memberInfo.getAppKey());
        result.put("appSecret", memberInfo.getAppSecret());
        result.put("appKeyExpiresin", memberInfo.getAppKeyExpiresin());
        result.put("termsAgreementYn", memberInfo.getTermsAgreementYn());
        result.put("reportCount", memberInfo.getReportCount());
        result.put("blacklistYn", memberInfo.getBlacklistYn());
        result.put("stockCareer", memberInfo.getStockCareer());
        result.put("withdrawYn", memberInfo.getWithdrawYn());
        result.put("authorities", memberInfo.getAuthorities());
        result.put("yield", yield);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 (id) 조회 성공", result));

    }

    @GetMapping("/code/{memberCode}")
    public ResponseEntity<ResponseDTO> selectMyMemberInfo(@PathVariable int memberCode) {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 (code) 조회 성공", memberService.selectMemberInfobyCode(memberCode)));
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
