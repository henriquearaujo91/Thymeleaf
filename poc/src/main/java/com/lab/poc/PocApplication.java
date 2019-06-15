package com.lab.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.lab.poc" }, exclude = JpaRepositoriesAutoConfiguration.class)
@EntityScan(basePackages = { "com.lab.poc.model" })
@EnableJpaRepositories(basePackages = { "com.lab.poc.repository" })
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

}
