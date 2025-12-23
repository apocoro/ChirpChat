package WGU.Capstone.ChirpCharts.config;

import WGU.Capstone.ChirpCharts.entity.Team;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config,
            CorsRegistry cors) {

        // Disable write operations for Team
        HttpMethod[] unsupportedActions = {
                HttpMethod.PUT,
                HttpMethod.POST,
                HttpMethod.DELETE
        };

        config.getExposureConfiguration()
                .forDomainType(Team.class)
                .withItemExposure((metadata, methods) ->
                        methods.disable(unsupportedActions))
                .withCollectionExposure((metadata, methods) ->
                        methods.disable(unsupportedActions));

        // Allow Angular frontend to access the API
        cors.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:4200",
                        "https://chirpcharts.com"
                )
                .allowedMethods("GET");
    }
}
