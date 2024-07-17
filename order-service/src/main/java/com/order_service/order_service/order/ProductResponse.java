package com.order_service.order_service.order;

import lombok.Data;

@Data
public class ProductResponse {
    private String status;
    private Product data;
}
