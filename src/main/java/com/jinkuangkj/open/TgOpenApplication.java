package com.jinkuangkj.open;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = {"com.jinkuangkj"})
@ImportResource("classpath:applicationContext-mybatis.xml")
@EnableAutoConfiguration
@EnableScheduling
@SpringBootApplication
public class TgOpenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TgOpenApplication.class, args);
	}

}
