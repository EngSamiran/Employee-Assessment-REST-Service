package com.eas.app_config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ApplicationConfiguration implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
	      .addResourceHandler("/URLToReachResourceLocation/**")
	      .addResourceLocations("/resources/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
