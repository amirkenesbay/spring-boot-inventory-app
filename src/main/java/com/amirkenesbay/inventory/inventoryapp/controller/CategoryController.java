package com.amirkenesbay.inventory.inventoryapp.controller;

import com.amirkenesbay.inventory.inventoryapp.entity.Category;
import com.amirkenesbay.inventory.inventoryapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @GetMapping("/categories")
    public String listCategories(Model model){
        List<Category> listCategories = repository.findAll();
        model.addAttribute("listCategories", listCategories);
        return "categories";
    }

    @GetMapping("/categories/new")
    public String showCategoryNewForm(Model model){
        model.addAttribute("category", new Category());
        return "category_form";
    }

    @PostMapping("/categories/save")
    public String saveCategory(Category category){
        repository.save(category);
        return "redirect:/categories";
    }
}
