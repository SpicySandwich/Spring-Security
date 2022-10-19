package com.springsecurity;

import com.springsecurity.repository.UserSecurityRepository_3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserSecurityRepository_3.class)
public class SpringsecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityJpaApplication.class, args);
	}

}
