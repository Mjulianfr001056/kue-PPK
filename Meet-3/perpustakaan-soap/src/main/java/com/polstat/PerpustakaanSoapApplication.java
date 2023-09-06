package com.polstat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.polstat.components.entity")
@EnableJpaRepositories("com.polstat.components.repository")

public class PerpustakaanSoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerpustakaanSoapApplication.class, args);
	}

}
