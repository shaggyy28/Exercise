package com.sagar.springmvc;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sagar.springmvc.controller.HelloController;
import com.sagar.springmvc.controller.SumController;

@Configuration
@ComponentScan(value = { "com.sagar.springmvc.controller" })
@EnableWebMvc
public class WebServletConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/resources/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		registry.viewResolver(resolver);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/get-res/**").addResourceLocations("file:/home/sagar/");
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean 
	public HandlerMapping getSimpleHander() {
		SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
		HashMap<String, Object> urlMap = new HashMap<>();
		urlMap.put("/sum", new SumController());
		handlerMapping.setUrlMap(urlMap);
		return handlerMapping;
	}
}
