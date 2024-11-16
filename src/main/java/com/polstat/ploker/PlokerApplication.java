package com.polstat.ploker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Memastikan Spring memindai seluruh paket
public class PlokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlokerApplication.class, args);
	}
}