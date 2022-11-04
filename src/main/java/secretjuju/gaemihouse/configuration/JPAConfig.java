package secretjuju.gaemihouse.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"secretjuju.gaemihouse"})
@EnableJpaRepositories(basePackages = "secretjuju.gaemihouse")
public class JPAConfig {
}
