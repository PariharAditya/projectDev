package com.example.inventoryservice;

import com.example.inventoryservice.model.InventoryData;
import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {

        return args -> {
            InventoryData inventoryModel = new InventoryData();
            inventoryModel.setSkuCode("phone13");
            inventoryModel.setQuantity(100);
            inventoryRepository.save(inventoryModel);

            InventoryData inventoryModel1 = new InventoryData();
            inventoryModel.setSkuCode("PC");
            inventoryModel.setQuantity(10);
            inventoryRepository.save(inventoryModel1);
        };
    }
}
