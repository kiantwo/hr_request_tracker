package com.example.hr_request_tracker.hr_request_tracker.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@Configuration
public class GlobalCorsConfig implements WebMvcConfigurer {

	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedMethods("*")
		.allowedOrigins("http://localhost:4200/")
		.allowedHeaders("*")
		.allowCredentials(false)
		.maxAge(-1);
		
		
	}
	
}
