package WGU.Capstone.ChirpCharts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Apply CORS to all endpoints
                        .allowedOrigins(
                                "http://localhost:4200", // Angular dev server
                                "http://localhost",      // Docker local testing
                                "http://18.222.22.63"   // EC2 instance
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowCredentials(true); // Allows cookies/auth if needed
            }
        };
    }
}
