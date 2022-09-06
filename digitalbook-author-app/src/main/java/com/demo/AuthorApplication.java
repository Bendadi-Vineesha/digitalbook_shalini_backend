package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableFeignClients
public class AuthorApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(AuthorApplication.class, args);
	}
	
	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowedOrigins("http://localhost:4200","http://localhost:9090");
        WebMvcConfigurer.super.addCorsMappings(registry);
    }

}
