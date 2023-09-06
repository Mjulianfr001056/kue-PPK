package com.polstat.perpustakaan2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.polstat.perpustakaan2.components.entity")
@EnableJpaRepositories("com.polstat.perpustakaan2.components.repository")
public class Perpustakaan2Application {

	public static void main(String[] args) {
		SpringApplication.run(Perpustakaan2Application.class, args);
	}

}
