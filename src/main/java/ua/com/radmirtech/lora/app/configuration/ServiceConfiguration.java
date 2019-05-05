package ua.com.radmirtech.lora.app.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * The Java-configuration of services.
 */
@Configuration
@ComponentScan(basePackages = "ua.com.radmirtech.lora.app.service")
public class ServiceConfiguration {
    private final DozerBeanMapper dozerBeanMapper;
    private final EntityManager entityManager;

    public ServiceConfiguration(final DozerBeanMapper dozerBeanMapper,
                                final EntityManager entityManager) {
        this.dozerBeanMapper = dozerBeanMapper;
        this.entityManager = entityManager;
    }

}
