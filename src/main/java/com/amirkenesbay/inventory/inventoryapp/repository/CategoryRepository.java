package com.amirkenesbay.inventory.inventoryapp.repository;

import com.amirkenesbay.inventory.inventoryapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
