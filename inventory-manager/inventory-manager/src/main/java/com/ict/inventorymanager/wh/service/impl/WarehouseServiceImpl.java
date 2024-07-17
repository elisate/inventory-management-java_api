package com.ict.inventorymanager.wh.service.impl;

import com.ict.inventorymanager.feign.ProductClient;
import com.ict.inventorymanager.wh.Product;
import com.ict.inventorymanager.wh.ProductResponse;
import com.ict.inventorymanager.wh.modeles.Warehouse;
import com.ict.inventorymanager.wh.repository.WarehouseRepository;
import com.ict.inventorymanager.wh.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {
//    WarehouseRepository warehouseRepo;

    private final WarehouseRepository warehouseRepo;
    private final ProductClient productClient;



    @Override

    public void createwarehouse(Warehouse warehouse) {
        warehouseRepo.save(warehouse);


    }

    @Override
    public void upadatewarehouse(Warehouse warehouse) {

    }

    @Override
    public void deletewarehouse(Warehouse warehouse) {

    }



    @Override
    public List<Warehouse> getAllwarehouse() {
        return warehouseRepo.findAll();
    }

    @Override
    public Warehouse getWarehouseById(Long id) {
        Warehouse warehouse  = warehouseRepo.findById(id).orElse(null);
        return warehouse;
    }

    @Override
    public void deleteWarehouseById(Long id) {
        warehouseRepo.deleteById(id);
    }

    @Override
    public void updateWarehouseById(Long id)
        {}


    @Override
    public Product getProductById(Long productId) {
        ProductResponse response = productClient.getProductById(productId);
        return response.getData();
    }
    }


