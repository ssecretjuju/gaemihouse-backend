package secretjuju.gaemihouse.coin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import secretjuju.gaemihouse.coin.dto.CoinDTO;
import secretjuju.gaemihouse.coin.service.CoinService;
import secretjuju.gaemihouse.common.ResponseDTO;

/**
 * <pre>
 * Class : PaymentController
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-09       차용준            최초 생성
 * </pre>
 *
 * @author 차용준 (최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
@RestController
@RequestMapping("/coin")
public class CoinController {

    private final CoinService coinService;

    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping("/select")
    public ResponseEntity<ResponseDTO> coinList() {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "코인 내역 조회 성공", coinService.selectCoinList()));
    }

    @GetMapping("/select/{memberId}")
    public ResponseEntity<ResponseDTO> selectCoinListById(@PathVariable("memberId") String memberId) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "코인 내역 조회 성공", coinService.selectCoinListById(memberId)));
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertCoin(@RequestBody CoinDTO coinDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"코인 내역 저장 성공", coinService.insertCoin(coinDTO)));

    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> updateCoin(@RequestBody CoinDTO coinDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"코인 수정(취소) 성공", coinService.updateCoin(coinDTO)));
    }


}
