package com.jinkuangkj.open.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter{

	/**
	 * 跨域配置
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*").allowedHeaders("*").allowedMethods("*");
	}
	
	/**
	 * 配置拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/*registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("/login/**");
		super.addInterceptors(registry);*/
	}
	
	

}
