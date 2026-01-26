package fr.eni.encheres.controller;

import fr.eni.encheres.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class CategoryController {

//    @GetMapping("/addCategory")
//    public String addCategory(Model model) {
//        model.addAttribute("name", this.categoryRepositorySQL.getAll());
//        return "addCategory";
//    }
//
//    @PostMapping("/addCategory")
//    public String addCategory(@RequestAttribute Category category, Model model) {
//        this.categoryRepositorySQL.createCategory(category);
//        return "redirect:/addCategory";
//
//    }
}
