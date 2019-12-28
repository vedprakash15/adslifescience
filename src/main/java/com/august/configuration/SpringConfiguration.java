package com.august.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.august.security.CsrfSecurity;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.august")
public class SpringConfiguration extends WebMvcConfigurerAdapter  {
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		//viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
	
	@Bean
	public CsrfSecurity csrfSecurity() {
		return new CsrfSecurity();
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CsrfSecurity());
	}
	
	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistration resRegistry) {
		resRegistry.addResourceLocations(resourceLocations)
	}*/
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("Inside resorce handller");
	    registry
	      .addResourceHandler("/resources/**")
	      .addResourceLocations("/resources/");
	    //System.out.println(registry);
	}
}
