package com.order_service.order_service.order.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "order_details")
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  private   Long id;
  private   Integer customerID;
  private   String orderDate;
  private   String orderStatus;
  private   Integer  totalAmount;
  private   String  paymentStatus;


}
