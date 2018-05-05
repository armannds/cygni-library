package se.cygni.boklan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
@SpringBootApplication
public class BoklanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoklanApplication.class, args);
	}
}
