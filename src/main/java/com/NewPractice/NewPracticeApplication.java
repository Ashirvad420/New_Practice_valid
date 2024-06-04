package com.NewPractice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NewPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewPracticeApplication.class, args);

	}

	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
}

// Bean annotation use only config file
