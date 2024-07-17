package com.order_service.order_service.order.service.impl;


import com.order_service.order_service.feign.ProductClient;
import com.order_service.order_service.order.Product;
import com.order_service.order_service.order.ProductResponse;
import com.order_service.order_service.order.model.OrderInfo;
import com.order_service.order_service.order.repository.OrderInfoRepository;
import com.order_service.order_service.order.service.OrderInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class OrderInfoServiceImpl implements OrderInfoService {
  private final OrderInfoRepository orderInfoRepository;
  private final ProductClient productClient;

    @Override
    public void createOrder(OrderInfo orderInfo) {
      orderInfoRepository.save(orderInfo);
    }



    @Override
    public OrderInfo getOrderById(Long id) {
        return null;
    }

  @Override
  public Product getProductById(Long productId) {
    ProductResponse response = productClient.getProductById(productId);
    return response.getData();
  }

  @Override
    public void deleteOrderById(Long id) {

    }

    @Override
    public void updateOrderById(Long id) {

    }

    @Override
    public List<OrderInfo> getAllOrders() {
        return orderInfoRepository.findAll();
    }
}
