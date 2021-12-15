package net.springboot.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class SpringbootBackend1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackend1Application.class, args);
	}
	
}