package com.order_service.order_service.feign;

import com.order_service.order_service.order.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product", url = "http://localhost:9098")

public interface ProductClient {
    @GetMapping("/product/getById/{id}")
    ProductResponse getProductById(@PathVariable("id") Long id);
}
