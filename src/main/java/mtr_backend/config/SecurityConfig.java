package mtr_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // CORSを有効化（CorsConfigurationSource Bean を参照）
            .cors(Customizer.withDefaults())

            // SPA + API なら、まずは無効化でOK（将来CSRF対策するなら構成と一緒に再検討）
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth
                // preflight対策：OPTIONSは通す
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                // 今は全許可（後で /api/** だけ認証、とかに変える）
                .anyRequest().permitAll()
            );

        return http.build();
    }
}
