package WGU.Capstone.ChirpCharts.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())           // disable CSRF protection (keep it off for API calls)
                .authorizeHttpRequests(auth -> auth     // allow all requests to API and other endpoints
                        .requestMatchers("/api/**").permitAll()
                        .anyRequest().permitAll()
                )
                .cors(Customizer.withDefaults());       // enable CORS using the CorsConfigurationSource bean

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // 🔹 Set allowed origins: only production Angular app (add localhost for dev testing if needed)
        config.setAllowedOrigins(
                List.of(
                        "https://chirpcharts.com" // production Angular frontend
                        // "http://localhost:4200" // optional for local dev
                )
        );

        // 🔹 Allow common HTTP methods for API
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // 🔹 Allow all headers
        config.setAllowedHeaders(List.of("*"));

        // 🔹 ADDED: allow credentials (cookies or authentication headers if needed)
        config.setAllowCredentials(true);

        // Map the CORS configuration to all endpoints
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
