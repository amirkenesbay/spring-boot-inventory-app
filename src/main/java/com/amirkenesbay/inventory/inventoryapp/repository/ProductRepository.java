package com.amirkenesbay.inventory.inventoryapp.repository;

import com.amirkenesbay.inventory.inventoryapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
