package com.shop.cafe;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer{

//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")	//모든 Url을 매핑한다.
//		.allowedOrigins("http://127.0.0.1:8080/")	//이 url을 허용하겠다.
//		.allowedMethods("*")	//Post,Get과 같은 Method임
//		.allowedHeaders("*")
//		.allowCredentials(true);	//쿠키&세션 정보도 허용한다!
//	}
}
