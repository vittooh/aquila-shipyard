package com.dbl.aquilashipyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class AquilaShipyardApplication {

	public static void main(String[] args) {
		SpringApplication.run(AquilaShipyardApplication.class, args);
	}
}
