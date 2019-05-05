package ua.com.radmirtech.lora.app.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DozerConfiguration {

    public DozerConfiguration() {

    }

    @Bean
    DozerBeanMapper dozerBeanMapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<String> mappingFiles = Arrays.asList(
                "dozer-configuration-devices.xml",
                "dozer-configuration-receipts.xml",
                "dozer-configuration-packets.xml",
                "dozerjdk8converters.xml"
        );
        mapper.setMappingFiles(mappingFiles);
        return mapper;
    }

}
