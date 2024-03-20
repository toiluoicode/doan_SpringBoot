package com.example.doan.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.doan.entity.Category;
import com.example.doan.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // xem danh sach category
    @GetMapping
    public String listCategory(Model model) {
        List<Category> category = categoryService.getAllCategories();
        model.addAttribute("categories", category);
        model.addAttribute("title", "category List");
        return "category/list";
    }
    // Goi form add category
    @GetMapping("/add")
    public String addCategoryForm(Model model){
        model.addAttribute("category", new Category());

        return "category/add";
    }
    // Add category
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("category") Category category, BindingResult result , Model model){
        if(result.hasErrors()){

            return "category/add";
        }
        categoryService.addCategory(category);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("id") long id, Model model){
        Category editCategory = categoryService.getCategoryById(id);
        if(editCategory != null){
            model.addAttribute("category", editCategory);

            return "category/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editCategory( @Valid @ModelAttribute("category") Category updateCategory ,BindingResult result, Model model){
        if(result.hasErrors()){

            return "category/edit";
        }
        categoryService.getAllCategories().stream()
                .filter(category -> category.getId() == updateCategory.getId())
                .findFirst()
                .ifPresent(category -> {categoryService.updateCategory(updateCategory);});
        return "redirect:/category";
    }

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }
}
