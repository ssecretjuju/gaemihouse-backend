package secretjuju.gaemihouse.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "secretjuju.gaemihouse")
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }
}
