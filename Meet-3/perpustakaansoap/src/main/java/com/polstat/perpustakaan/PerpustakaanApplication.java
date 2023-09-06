package com.polstat.perpustakaan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.polstat.perpustakaan.entity")
@EnableJpaRepositories("com.polstat.perpustakaan.repository")

public class PerpustakaanApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerpustakaanApplication.class, args);
	}

}
