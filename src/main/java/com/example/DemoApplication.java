package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	 public static final String ISO8601_TIMESTAMP_FORMAT = "yyyy-MM-dd\'T\'HH:mm:ss\'Z\'";
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner setup(ToDoRepository toDoRepository) {
		return (args) -> {
			toDoRepository.save(new ToDo("Remove unused imports", true));
			toDoRepository.save(new ToDo("Clean the code", true));
			toDoRepository.save(new ToDo("Build the artifacts", false));
			toDoRepository.save(new ToDo("Deploy the jar file", true));
			logger.info("The sample data has been generated");
		};
	}*/
}
