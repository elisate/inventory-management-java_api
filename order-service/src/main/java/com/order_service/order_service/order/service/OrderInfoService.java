package com.order_service.order_service.order.service;

import com.order_service.order_service.order.Product;
import com.order_service.order_service.order.model.OrderInfo;

import java.util.List;

public interface OrderInfoService {
  void createOrder(OrderInfo orderInfo);
    void deleteOrderById(Long id);
    void updateOrderById(Long id);
  List<OrderInfo> getAllOrders();
  OrderInfo getOrderById(Long id);

  //the implemantation of services communication
  Product getProductById(Long id);
}
