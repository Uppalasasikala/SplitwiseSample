package com.finalproject;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.finalproject.controller", "com.finalproject.service"})
public class SplitWiseTrackersampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitWiseTrackersampleApplication.class, args);
	}

}
