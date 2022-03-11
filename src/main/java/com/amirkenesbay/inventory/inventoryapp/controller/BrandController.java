package com.amirkenesbay.inventory.inventoryapp.controller;

import com.amirkenesbay.inventory.inventoryapp.entity.Brand;
import com.amirkenesbay.inventory.inventoryapp.entity.Category;
import com.amirkenesbay.inventory.inventoryapp.repository.BrandRepository;
import com.amirkenesbay.inventory.inventoryapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/brands/new")
    public String showCreateNewBrandForm(Model model) {
        List<Category> listCategories = categoryRepository.findAll();
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", new Brand());
        return "brand_form";
    }

    @PostMapping("/brands/save")
    public String saveBrand(Brand brand) {
        brandRepository.save(brand);
        return "redirect:/";
    }

    @GetMapping("/brands")
    public String listBrands(Model model) {
        List<Brand> listBrands = brandRepository.findAll();
        model.addAttribute("listBrands", listBrands);
        return "brands";
    }

    @GetMapping("/brands/edit/{id}")
    public String showEditBrandForm(@PathVariable("id") Integer id, Model model){
        List<Category> listCategories = categoryRepository.findAll();
        Brand brand = brandRepository.findById(id).get();
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", brand);
        return "brand_form";
    }

    @GetMapping("brands/delete/{id}")
    public String deleteBrand(@PathVariable("id") Integer id, Model model , RedirectAttributes redirectAttributes){
        brandRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "The Brand ID " + id + " has been deleted");
        return "redirect:/brands";
    }
}
