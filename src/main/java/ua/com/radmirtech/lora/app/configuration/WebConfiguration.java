package ua.com.radmirtech.lora.app.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * The Java-configuration of Web.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ua.com.radmirtech.lora.app.controller")
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedHeaders("Content-Type", "Authorization")
                .exposedHeaders("Content-Type", "Authorization")
                .maxAge(3600);
    }
}
