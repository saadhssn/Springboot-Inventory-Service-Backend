package com.aimnode.inventory_service.service;

import com.aimnode.inventory_service.model.Inventory;
import com.aimnode.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Check if SKU is in stock
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

    // Save inventory to database
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
}
