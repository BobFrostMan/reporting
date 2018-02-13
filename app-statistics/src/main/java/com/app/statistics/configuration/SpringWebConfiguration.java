package com.app.statistics.configuration;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.app.statistics.api" })
public class SpringWebConfiguration extends WebMvcConfigurerAdapter {
	private static final String PATH_TO_PAGE_FOLDER = "/WEB-INF/pages/";
	private static final String DEFAULT_ENCODING = "utf-8";
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
	private static final String HTML = ".html";

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/WEB-INF/pages/**").addResourceLocations("/pages/");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	@Bean
	public FreeMarkerViewResolver freemarkerViewResolver() {
		final FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setCache(true);
		resolver.setPrefix("");
		resolver.setSuffix(HTML);
		resolver.setContentType(CONTENT_TYPE);
		return resolver;
	}

	@Bean
	public FreeMarkerConfigurer freemarkerConfig() {
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPath(PATH_TO_PAGE_FOLDER);
		freeMarkerConfigurer.setDefaultEncoding(DEFAULT_ENCODING);
		return freeMarkerConfigurer;
	}


}