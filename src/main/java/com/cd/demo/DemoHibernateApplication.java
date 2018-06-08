package com.cd.demo;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class DemoHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoHibernateApplication.class, args);
	}


	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = jsonConverter.getObjectMapper();
		//防止死循环
		objectMapper.registerModule(new Hibernate5Module()); 
		//设置日期格式，不能解决夏令时问题
		SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd");
		objectMapper.setDateFormat(smt);
		jsonConverter.setObjectMapper(objectMapper);
		return jsonConverter;
	}

}
