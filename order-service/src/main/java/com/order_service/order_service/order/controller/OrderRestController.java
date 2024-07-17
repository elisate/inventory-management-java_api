package com.order_service.order_service.order.controller;

import com.order_service.order_service.order.Product;
import com.order_service.order_service.order.model.OrderInfo;
import com.order_service.order_service.order.service.OrderInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("order")
public class OrderRestController {
    private final OrderInfoService orderInfoService;

    @PostMapping("/create_order")
    public ResponseEntity<?> createOrder(@RequestBody OrderInfo orderInfo) {
        Map<String, Object> response = new HashMap<>();
        orderInfoService.createOrder(orderInfo);
        response.put("status", "success");
        response.put("message", "New order was created");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all_orders")
    public ResponseEntity<List<OrderInfo>> getAllOrders() {
        List<OrderInfo> orders = orderInfoService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = orderInfoService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
