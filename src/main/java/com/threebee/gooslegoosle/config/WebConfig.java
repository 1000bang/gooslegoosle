package com.threebee.gooslegoosle.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Value("${file.path}")
	private String uploadFolder;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);

		registry.addResourceHandler("/magazine/**")
		.addResourceLocations("file:///" + uploadFolder) 
		.setCachePeriod(60 * 10 * 6) 
		.resourceChain(true) 
		.addResolver(new PathResourceResolver());
		
	}
	
}
