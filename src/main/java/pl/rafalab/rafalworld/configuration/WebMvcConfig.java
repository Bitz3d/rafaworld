package pl.rafalab.rafalworld.configuration;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public BCryptPasswordEncoder pwdEncrypt(){
        BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
        return  bcp;
    }
// Obsluga plików do 5MB
    @Bean
    public MultipartConfigElement multipartConfigElement(){
    	MultipartConfigFactory configFactory = new MultipartConfigFactory();
    	configFactory.setMaxFileSize("5MB");
    	configFactory.setMaxRequestSize("5MB");
    	return configFactory.createMultipartConfig();
    }
    

}
