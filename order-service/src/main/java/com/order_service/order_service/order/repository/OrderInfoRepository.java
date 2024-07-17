package com.order_service.order_service.order.repository;

import com.order_service.order_service.order.model.OrderInfo;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {


}
