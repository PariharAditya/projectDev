package com.example.inventoryservice.repository;

import com.example.inventoryservice.model.InventoryData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryData, Long> {
    public Optional<InventoryData> findBySkuCode(String skuCode);

}
