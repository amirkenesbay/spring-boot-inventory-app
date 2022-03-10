package com.amirkenesbay.inventory.inventoryapp.controller;

import com.amirkenesbay.inventory.inventoryapp.entity.Category;
import com.amirkenesbay.inventory.inventoryapp.entity.Product;
import com.amirkenesbay.inventory.inventoryapp.repository.CategoryRepository;
import com.amirkenesbay.inventory.inventoryapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/products/new")
    public String showNewProductForm(Model model) {
        List<Category> listCategories = categoryRepository.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("listCategories", listCategories);
        return "product_form";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String[] detailNames = request.getParameterValues("detailName");
        String[] detailValues = request.getParameterValues("detailValue");
        for (int i = 0; i < detailNames.length; i++) {
            product.addDetail(detailNames[i], detailValues[i]);
        }
        productRepository.save(product);
        redirectAttributes.addFlashAttribute("message", "The product has been saved successfully");
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        return "products";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
        Product product = productRepository.findById(id).get();
        model.addAttribute("product", product);

        List<Category> listCategories = categoryRepository.findAll();
        model.addAttribute("listCategories", listCategories);
        return "product_form";
    }

    @GetMapping("products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        productRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "The product ID " + id + " has been deleted");
        return "redirect:/products";
    }
}
