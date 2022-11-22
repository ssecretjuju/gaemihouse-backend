package secretjuju.gaemihouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}


//package secretjuju.gaemihouse;
//
//        import org.springframework.boot.SpringApplication;
//        import org.springframework.boot.autoconfigure.SpringBootApplication;
//        import org.springframework.boot.builder.SpringApplicationBuilder;
//
//@SpringBootApplication
//public class DemoApplication {
//
//    public static final String APPLICATION_LOCATIONS = "sptring.config.location="
//            + "classpath:application.yml,"
//            + "classpath:aws.yml";
//
//    public static void main(String[] args) {
//        new SpringApplicationBuilder(DemoApplication.class)
//                .properties(APPLICATION_LOCATIONS)
//                .run(args);
//    }
//
//}
