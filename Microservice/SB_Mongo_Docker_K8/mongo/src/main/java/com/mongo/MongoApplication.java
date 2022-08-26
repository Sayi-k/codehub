package com.mongo;

import com.mongo.model.User;
import com.mongo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

	@Autowired
	UserRepo repo;

	@Override
	public void run(String... args) throws Exception {
		//repo.deleteAll();

		repo.save(User.builder()
				.name("Raj")
				.settings(Map.of("age", "32",
						"salary", "200000"))
				.build());

		repo.save(User.builder()
				.name("Sam")
				.settings(Map.of("age", "54",
						"salary", "560000"))
				.build());
	}
}
