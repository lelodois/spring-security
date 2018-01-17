package br.com.lelo.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfigutarion extends WebMvcConfigurerAdapter {

	public void addResourceHandlers(ResourceHandlerRegistry reg) {
		reg.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/");
	}

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "home");
	}
}
