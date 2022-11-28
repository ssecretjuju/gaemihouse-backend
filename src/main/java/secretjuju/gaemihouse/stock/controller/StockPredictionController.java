package secretjuju.gaemihouse.stock.controller;

import lombok.Value;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.stock.dto.StockPredictionDTO;
import secretjuju.gaemihouse.stock.model.StockPrediction;
import secretjuju.gaemihouse.stock.service.StockPredictionService;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StockPredictionController {
    // XR에서 검색(요청)이 들어오면 검색어 유효성 검사 후 AI 서버로 요청. 응답 데이터(사진 두장) XR로 응답
    private final StockPredictionService stockPredictionService;

    public StockPredictionController(StockPredictionService stockPredictionService) {
        this.stockPredictionService = stockPredictionService;
    }

    @PostMapping("/stock-prediction/{stockName}")
    public ResponseEntity<ResponseDTO> getStockPredictionByStockName(@PathVariable String stockName) {

        // if(exist in json? stockname) => 결과 반환 else 오류 반환

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<StockPredictionDTO> stockPredictions = stockPredictionService.getStockPredictionByStockName(stockName);

        String imageUrl1 = stockPredictions.get(0).getStockPredictionImage1();
        String imageUrl2 = stockPredictions.get(0).getStockPredictionImage2();
        Map<String, String> url = new HashMap<>();
        url.put("url1", imageUrl1);
        url.put("url2", imageUrl2);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "successful", url));
    }
}
