package ua.com.radmirtech.lora.app.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Java-configuration for database.
 */
@Configuration
@ComponentScan(basePackages = "ua.com.radmirtech.lora.app.entity")
@EnableJpaRepositories(basePackages = "ua.com.radmirtech.lora.app.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {

}
