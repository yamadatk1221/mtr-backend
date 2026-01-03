package mtr_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // 開発用（必要に応じて増やす）
        config.setAllowedOrigins(List.of(
                "http://localhost:3000"
                // "https://xxxx.cloudfront.net"
        ));

        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));

        // 将来Cookie/セッションやAuthorizationヘッダを使うなら true 前提が無難
        config.setAllowCredentials(true);

        // フロント側で読みたいレスポンスヘッダがある場合だけ
        // config.setExposedHeaders(List.of("Set-Cookie", "Location"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}

