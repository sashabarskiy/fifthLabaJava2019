package ua.com.radmirtech.lora.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * The Java-configuration for application.
 */
@Configuration
@Import({
        DatabaseConfiguration.class,
        WebConfiguration.class,
        WebSecurityConfig.class,
        ServiceConfiguration.class,
        DozerConfiguration.class
})
public class ApplicationConfiguration {
}
