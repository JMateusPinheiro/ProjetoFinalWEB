package br.com.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.web.interceptors.LoginInterceptor;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter{

	@Autowired
	private LoginInterceptor loginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry)	{	
		registry.addInterceptor(loginInterceptor).addPathPatterns("/usuario/**","/adm/**","/login/**","/cadastro/**");
	}
}
