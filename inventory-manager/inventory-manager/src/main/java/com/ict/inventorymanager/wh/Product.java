package com.ict.inventorymanager.wh;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String prod_name;
    private  String prod_category;
    private  int prod_price;
    private  String pro_expdate;
}
