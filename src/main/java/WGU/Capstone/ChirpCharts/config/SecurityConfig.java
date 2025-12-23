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
                .csrf(csrf -> csrf.disable()) // disable CSRF protection
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll()  // allow all API endpoints
                        .requestMatchers(org.springframework.http.HttpMethod.OPTIONS, "/**").permitAll() // allow preflight requests
                        .anyRequest().permitAll() // allow other requests if needed
                )
                .cors(Customizer.withDefaults()); // enable CORS using the CorsConfigurationSource bean

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // Allowed origins for frontend
        config.setAllowedOrigins(
                List.of(
                        "https://chirpcharts.com" // production frontend
                        // "http://localhost:4200" // uncomment for local dev
                )
        );

        // Allowed HTTP methods
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Allowed headers
        config.setAllowedHeaders(List.of("*"));

        // Allow credentials (cookies/auth headers)
        config.setAllowCredentials(true);

        // Map CORS config to all endpoints
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
