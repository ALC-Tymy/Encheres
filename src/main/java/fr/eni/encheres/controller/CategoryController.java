package fr.eni.encheres.controller;

import fr.eni.encheres.repository.CategoryRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CategoryController {
    CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/addCategory")
    public String displayCategory(Model model) {
        model.addAttribute("categoryList", this.categoryRepository.getAll());
        return "addCategory";
    }
}