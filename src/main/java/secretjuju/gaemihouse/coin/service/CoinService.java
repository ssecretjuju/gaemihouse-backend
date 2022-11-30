package secretjuju.gaemihouse.coin.service;

import org.springframework.stereotype.Service;
import secretjuju.gaemihouse.coin.dao.CoinMapper;
import secretjuju.gaemihouse.coin.dto.CoinDTO;

import java.util.List;

/**
 * <pre>
 * Class : PaymentService
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
@Service
public class CoinService {

    private final CoinMapper coinMapper;

    public CoinService(CoinMapper coinMapper) {
        this.coinMapper = coinMapper;
    }


    public Object selectCoinList() {
        List<CoinDTO> coinList = coinMapper.selectCoinList();
        return coinList;
    }

    public Object selectCoinListById(String memberId) {
        CoinDTO coinList = coinMapper.selectCoinListById(memberId);
        return coinList;
    }

    public Object insertCoin(CoinDTO coinDTO) {
        int insertPayment = coinMapper.insertCoin(coinDTO);
        return (insertPayment > 0) ? "코인 내역 입력 성공!" : "코인 내역 입력 실패 ㅜ";
    }

    public Object updateCoin(CoinDTO coinDTO) {

        int updateCoin = coinMapper.updateCoin(coinDTO);
        int coinAmount = coinMapper.selectCoinListById(coinDTO.getMemberId()).getCoinAmount();
        return (updateCoin > 0) ? coinAmount : "코인 수정(취소) 실패 ㅜ";
    }
}
