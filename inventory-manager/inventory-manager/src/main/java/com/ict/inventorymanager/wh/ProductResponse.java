package com.ict.inventorymanager.wh;

import lombok.Data;

@Data
public class ProductResponse {
    private String status;
    private Product data;
}
