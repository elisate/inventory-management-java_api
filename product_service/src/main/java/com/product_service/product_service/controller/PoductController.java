package com.product_service.product_service.controller;

import com.product_service.product_service.model.Product;
import com.product_service.product_service.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class PoductController {
    @Autowired
    ProductService productService;

    @PostMapping("/create_product")
    public ResponseEntity<?> createProduct(@RequestBody Product product, @RequestAttribute("role") String role) {
        Map<String, Object> response = new HashMap<>();

        if (!"ADMIN".equals(role)) {
            response.put("status", "error");
            response.put("message", "You are not authorized to create products");
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }

        productService.createProduct(product);
        response.put("status", "success");
        response.put("message", "Product well registered");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get_products")
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", products);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("data", product);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Product not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
