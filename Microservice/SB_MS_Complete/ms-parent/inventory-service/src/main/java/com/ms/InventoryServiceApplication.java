package com.ms;

import com.ms.entity.Inventory;
import com.ms.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory1 = Inventory.builder()
					.skuCode("samsung_13")
					.quantity(100)
					.build();
			Inventory inventory2 = Inventory.builder()
					.skuCode("samsung_16")
					.quantity(0)
					.build();
			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};
	}

}
