package io.zwen.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // We are telling springboot that this is a springboot app. THis is the entrance
public class CourseApiApp {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiApp.class, args); // create a server container and the whole app can run in it
		
	}

}
