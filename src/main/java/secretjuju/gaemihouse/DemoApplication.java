package secretjuju.gaemihouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import secretjuju.gaemihouse.member.dto.MemberDTO;
import secretjuju.gaemihouse.member.service.KoreaInvestmentService;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoApplication.class, args);
    }

}
