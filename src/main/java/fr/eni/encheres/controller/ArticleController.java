package fr.eni.encheres.controller;

import fr.eni.encheres.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String readAllArticle(Model model){
        model.addAttribute("listArticle", articleService.readAll());
        return "index";
    }
}