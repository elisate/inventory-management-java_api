package com.product_service.product_service.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String prod_name;
    private  String prod_category;
    private  int prod_price;
    private  String pro_expdate;

}
