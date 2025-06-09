package com.basa.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CourseApiDemoApplication {

	public static void main(String[] args) {
		//Arrays.stream(args).forEach(System.out::println);
		SpringApplication.run(CourseApiDemoApplication.class, args);
	}


}
