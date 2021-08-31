package com.mongodemo.demoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.mongodemo.filters.FilterClass;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean filt(){
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new FilterClass());
		filter.addUrlPatterns("/abc/*");
		return filter;
	}

}
