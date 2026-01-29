package fr.eni.encheres.controller;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArticleController {
    ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable("id") final long id, Model model){
        //récup des détails d'un article
        Article article = articleService.readById(id);
        model.addAttribute("article", article);
        //Affichage de la page détails d'un article
        return "details";
    }


}