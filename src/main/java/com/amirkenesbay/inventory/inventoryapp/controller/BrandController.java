package com.amirkenesbay.inventory.inventoryapp.controller;

import com.amirkenesbay.inventory.inventoryapp.entity.Brand;
import com.amirkenesbay.inventory.inventoryapp.entity.Category;
import com.amirkenesbay.inventory.inventoryapp.repository.BrandRepository;
import com.amirkenesbay.inventory.inventoryapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/brands/new")
    public String showCreateNewBrandForm(Model model){
        List<Category> listCategories = categoryRepository.findAll();
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", new Brand());
        return "brand_form";
    }

    @PostMapping("/brands/save")
    public String saveBrand(Brand brand){
        brandRepository.save(brand);
        return "redirect:/";
    }
}
