package com.jinkuangkj.open.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter{

	@Autowired
	AuthInterceptor authInterceptor;
	
	/**
	 * 跨域配置
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*").allowedHeaders("*").allowedMethods("*");
	}
	
	
	@Override  
    public void addInterceptors(InterceptorRegistry registry) {  
        //注册自定义拦截器，添加拦截路径和排除拦截路径  
        registry.addInterceptor(authInterceptor)
        	.addPathPatterns("/openAdmin/**")
        	.excludePathPatterns("/openAdmin/login");  
    } 

}
