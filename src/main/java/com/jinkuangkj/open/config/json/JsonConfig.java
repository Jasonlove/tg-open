package com.jinkuangkj.open.config.json;


import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 重新定义responseBody的 json
 * @author Jason
 *
 */


@Configuration
public class JsonConfig {

	
	@Bean
	public ObjectMapper setObjcetMapper(Jackson2ObjectMapperBuilder builder) {
		 ObjectMapper objectMapper = builder.createXmlMapper(false).build();
		 objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
	            @Override
	            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
	                jsonGenerator.writeString("");
	            }
	        });
		 objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		 /*
		  * 设置为null的的时候去掉属性 
		  * objectMapper.setSerializationInclusion(Include.NON_NULL);
		  */
		return objectMapper;
	}
	
	
}
