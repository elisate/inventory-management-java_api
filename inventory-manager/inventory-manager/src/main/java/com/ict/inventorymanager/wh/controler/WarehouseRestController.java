package com.ict.inventorymanager.wh.controler;

import com.ict.inventorymanager.wh.Product;
import com.ict.inventorymanager.wh.modeles.Warehouse;
import com.ict.inventorymanager.wh.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequestMapping("/api/warehouse")
@AllArgsConstructor
@RestController
public class WarehouseRestController {

    private final WarehouseService warehouseService;

    @PostMapping("/v1/create")
    public ResponseEntity<?> createWarehouse(@RequestBody Warehouse warehouse) {
        Map<String, Object> response = new HashMap<>();
        warehouseService.createwarehouse(warehouse);
        response.put("status", "sucess");
        response.put("message", "warehouse created well");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/v1/get")
    public ResponseEntity<?> getAllWarehouse() {
        List<Warehouse> warehouses = warehouseService.getAllwarehouse();
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", warehouses);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/v1/getById/{id}")
    public ResponseEntity<?> getWarehouseById(@PathVariable Long id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id);
        if (warehouse == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Warehouse not found with id: " + id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("data", warehouse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @DeleteMapping("/v1/deleteById/{id}")
    public ResponseEntity<?> deleteWarehouseById(@PathVariable Long id) {
        try {
            warehouseService.deleteWarehouseById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Warehouse deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Failed to delete warehouse");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = warehouseService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
