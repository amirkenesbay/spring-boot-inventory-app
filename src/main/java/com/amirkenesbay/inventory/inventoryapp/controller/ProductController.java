package com.amirkenesbay.inventory.inventoryapp.controller;

import com.amirkenesbay.inventory.inventoryapp.entity.Category;
import com.amirkenesbay.inventory.inventoryapp.entity.Product;
import com.amirkenesbay.inventory.inventoryapp.repository.CategoryRepository;
import com.amirkenesbay.inventory.inventoryapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/products/new")
    public String showNewProductForm(Model model){
        List<Category> listCategories = categoryRepository.findAll();
        model.addAttribute("product", new Product());
        return "product_form";
    }
}
