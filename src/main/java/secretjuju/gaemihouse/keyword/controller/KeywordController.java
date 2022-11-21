package secretjuju.gaemihouse.keyword.controller;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import secretjuju.gaemihouse.common.ResponseDTO;
import secretjuju.gaemihouse.keyword.dto.KeywordDTO;
import secretjuju.gaemihouse.keyword.service.KeywordService;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class KeywordController {

    private final KeywordService keywordService;

    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    // 당일 키워드 조회
    @GetMapping("/keyword")
    public ResponseEntity<ResponseDTO> findByKeywordDate() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        Date start = cal.getTime();

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        Date end = cal.getTime();

        List<KeywordDTO> keywords = keywordService.findAllByKeywordDateBetween(start, end);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "successful", keywords));
    }

}
