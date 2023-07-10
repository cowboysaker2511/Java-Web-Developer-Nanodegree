package com.example.SpringSecurity_Demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	private DogRepository dogRepository ;

    public SpringSecurityDemoApplication(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {
            dogRepository.save(new Dog("Name 1", "Breed 1", "Origin 1"));
            dogRepository.save(new Dog("Name 2", "Breed 2", "Origin 2"));
		};
	}
}
