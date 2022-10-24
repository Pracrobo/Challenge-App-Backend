package com.whale.challenge.module.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;
import com.whale.challenge.module.security.HtmlCharacterEscapes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

	@Value("${custom.path.upload-images}")
	private String uploadImagesPath;
	private final ObjectMapper objectMapper;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
				.addMapping("/**")
				.allowedOrigins("http://localhost:3000")
				.exposedHeaders("TOKEN");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String sb = "file:" +
				uploadImagesPath +
				"/";

		registry
				.addResourceHandler("/hepc-upload/**")
				.addResourceLocations(sb);
	}

	@Bean
	public FilterRegistrationBean<XssEscapeServletFilter> filterFilterRegistrationBean() {
		FilterRegistrationBean<XssEscapeServletFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new XssEscapeServletFilter());
		filterRegistrationBean.setOrder(1);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(jsonEscapeConverter());
	}

	@Bean
	public MappingJackson2HttpMessageConverter jsonEscapeConverter() {
		ObjectMapper copy = this.objectMapper.copy();
		copy.getFactory().setCharacterEscapes(new HtmlCharacterEscapes());
		return new MappingJackson2HttpMessageConverter(copy);
	}
}
