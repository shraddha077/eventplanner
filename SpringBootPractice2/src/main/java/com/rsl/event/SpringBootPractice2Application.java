package com.rsl.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootPractice2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPractice2Application.class, args);
		
		System.out.println("\n*Note:- While doing delete and update operations. Id of table need to be provide *\n");
	}

}
