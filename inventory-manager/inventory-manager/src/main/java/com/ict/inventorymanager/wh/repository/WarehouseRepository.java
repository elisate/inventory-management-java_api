package com.ict.inventorymanager.wh.repository;

import com.ict.inventorymanager.wh.modeles.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
