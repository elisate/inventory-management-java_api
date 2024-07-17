package com.ict.inventorymanager;

//import com.ict.inventorymanager.service.KafkaProducerService;
import com.ict.inventorymanager.wh.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.ict.inventorymanager.feign")
public class InventoryManagerApplication implements CommandLineRunner {

    @Autowired
    private KafkaProducerService producerService;

    public static void main(String[] args) {
        SpringApplication.run(InventoryManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        producerService.sendMessage("Hello from Inventory Manager!");
    }
}
