package com.apress.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.apress.spring.service.JournalService;

@SpringBootApplication
public class SimpleJpaAppApplication {
	private static final Logger log = LoggerFactory.getLogger(SimpleJpaAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SimpleJpaAppApplication.class, args);
	}

	@Bean
	CommandLineRunner start(JournalService service) {
		return args -> {
			log.info("@@ 데이터 생성....");
			service.insertData();
			log.info("@@ findAll() 호출...");
			service.findAll().forEach(entry -> log.info(entry.toString()));
		};
	}

}
