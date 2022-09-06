package com.demo.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class WebConfig  {

	@Bean
	public CorsWebFilter corsWebFilter() {
	    final CorsConfiguration config = new CorsConfiguration();
	    config.setAllowedOrigins((Collections.singletonList("*")));
	    config.setMaxAge(3600L);
	    config.setAllowedMethods(Arrays.asList("*"));
	    config.addAllowedHeader("*");
	    config.addAllowedOrigin("*");
	    
	    

	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", config);

	    //return new CorsWebFilter(source);
	    return new CorsWebFilter((CorsConfigurationSource) source);
	}
}