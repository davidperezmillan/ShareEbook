package com.nonave.sharebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ShareBookAplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareBookAplication.class, args);
	}

	private void commitTry(){
		System.out.println("Just to test the connection with Blue Ocean");
	}
}
