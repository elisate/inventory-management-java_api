package com.order_service.order_service.order;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String prod_name;
    private  String prod_category;
    private  int prod_price;
    private  String pro_expdate;
}
