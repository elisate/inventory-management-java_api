package com.product_service.product_service.service;

import com.product_service.product_service.model.Product;

import java.util.List;

public interface ProductService {
    void  createProduct(Product product);
    void UpadateProductById(Long id);

    List<Product>getAllProduct();
    Product getProductById(Long id);


}
