package com.product_service.product_service.service.impl;

import com.product_service.product_service.model.Product;
import com.product_service.product_service.repository.ProductRepository;
import com.product_service.product_service.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceimpl implements ProductService {
    ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);

    }

    @Override
    public void UpadateProductById(Long id) {

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

}
