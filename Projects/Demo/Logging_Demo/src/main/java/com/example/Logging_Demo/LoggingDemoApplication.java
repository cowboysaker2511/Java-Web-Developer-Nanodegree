package com.example.Logging_Demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LoggingDemoApplication {

	private static Logger logger = LoggerFactory.getLogger(LoggingDemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(LoggingDemoApplication.class, args);
		String bug = "Username not found.";
		logger.error("This is bug: " + bug);
	}

}
