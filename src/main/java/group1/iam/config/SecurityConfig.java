package group1.iam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Secure all endpoints except the homepage (optional)
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
            )
            // Enable OAuth2 Login using the configuration from application.properties
            .oauth2Login(withDefaults()); 
        return http.build();
    }
}