package com.amirkenesbay.inventory.inventoryapp.repository;

import com.amirkenesbay.inventory.inventoryapp.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
