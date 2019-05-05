package ua.com.radmirtech.lora.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/**").permitAll();
//                .antMatchers("/api/login").permitAll()
//                .antMatchers("/api/applications/{applicationID}/nodes").access("@webSecurity.check(authentication,request)")
//                .antMatchers("/api/applications/{applicationID}/nodes/{devEUI}/volumes/date").access("@webSecurity.check(authentication,request)")
//                .antMatchers("/api/applications/{applicationID}/check").access("@webSecurity.check(authentication,request)")
//                .antMatchers("/api/applications/{applicationID}/nodes/{devEUI}/receipt").access("@webSecurity.check(authentication,request)")
//                .anyRequest().authenticated()
//                .and()
//                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
