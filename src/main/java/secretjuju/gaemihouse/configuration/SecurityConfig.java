package secretjuju.gaemihouse.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import secretjuju.gaemihouse.jwt.JwtAccessDeniedHandler;
import secretjuju.gaemihouse.jwt.JwtAuthenticationEntryPoint;
import secretjuju.gaemihouse.jwt.TokenProvider;

import java.util.Arrays;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(TokenProvider tokenProvider, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint
            , JwtAccessDeniedHandler jwtAccessDeniedHandler){
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                // 외부에서 이미지 파일에 접근 가능 하도록 설정
                .ignoring()
                .antMatchers("/productimgs/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                // CSRF 설정 Disable
                .csrf().disable()
                // exception handling
                .exceptionHandling()
                //클라이언트의 자격 증명을 요청하는 HTTP응답을 보냄. -> 클라이언트는 리소스 요청을 위해 이름,암호 같은 자격을 포함해야함.
                //인증이 되지않은 유저가 요청을 했을때 동작된다.
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                //서버에 요청을 할 때 액세스가 가능한지 권한을 체크후 액세스 할 수 없는 요청을 했을시 동작된다.
                .accessDeniedHandler(jwtAccessDeniedHandler)

                // 시큐리티는 기본적으로 세션을 사용하지만 API 서버에선 세션을 사용하지 않기 때문에 세션 설정을 Stateless 로 설정
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                    // 로그인, 회원가입 API 는 토큰이 없는 상태에서 요청이 들어오기 때문에 permitAll 설정
                    .and()
                    .authorizeRequests()
//                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                    .antMatchers("/auth/**").permitAll()
//                    .antMatchers("/member/**").hasAnyRole("USER")  // 나머지 API 는 전부 인증 필요

                .and()
                .cors()
                .and()
                // JwtFilter 를 addFilterBefore 로 등록했던 JwtSecurityConfig 클래스를 적용
                .apply(new JwtSecurityConfig(tokenProvider));
        System.out.println("security를 거쳐감");
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        // 로컬 React에서 오는 요청은 CORS 허용해준다.
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Content-Type", "Access-Control-Allow-Headers", "Authorization", "X-Requested-With"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}