package WGU.Capstone.ChirpCharts.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("https://chirpcharts.com",
                        "https://frontend-angular-chirpcharts-production.up.railway.app",
                        //"https://welcoming-embrace-production.up.railway.app"
                        "https://striking-flow-production-66bd.up.railway.app")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600);
    }
}