package com.ict.inventorymanager.wh.service;

import com.ict.inventorymanager.wh.Product;
import com.ict.inventorymanager.wh.modeles.Warehouse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface WarehouseService{
void createwarehouse(Warehouse warehouse);

void  deletewarehouse(Warehouse warehouse);

void upadatewarehouse(Warehouse warehouse);

List<Warehouse> getAllwarehouse();
Warehouse getWarehouseById(Long id);

void deleteWarehouseById(Long id);
void updateWarehouseById(Long id);
Product getProductById(Long id);
}
