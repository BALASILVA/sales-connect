package com.orgin.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class SalesconnectApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SalesconnectApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = 
				new UrlBasedCorsConfigurationSource();
		final CorsConfiguration confic = new CorsConfiguration();
		confic.setAllowCredentials(true);
		confic.addAllowedHeader("*");
		confic.addAllowedOrigin("*");
		confic.addAllowedMethod("OPTIONS");
		confic.addAllowedMethod("GET");
		confic.addAllowedMethod("PUT");
		confic.addAllowedMethod("POST");
		confic.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", confic);
		return new CorsFilter(source);
	}
}
