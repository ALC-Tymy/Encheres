package fr.eni.encheres.controller;


import fr.eni.encheres.entity.Article;
import fr.eni.encheres.entity.Searching;
import fr.eni.encheres.service.ArticleService;
import fr.eni.encheres.service.CategoryService;
import fr.eni.encheres.service.DeliveryAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
public class HomeController {
    ArticleService articleService;
    DeliveryAddressService deliveryAddressService;
    CategoryService categoryService;
    Searching searching = new Searching();

    public HomeController(ArticleService articleService, CategoryService categoryService, DeliveryAddressService deliveryAddressService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
        this.deliveryAddressService = deliveryAddressService;
    }

    @GetMapping("/")
    public String readAllArticle(Model model) {
        // Liste des articles créés mais pas encore en vente, pas pris en compte dans le filtre de recherche
        List<Article> allArticlesCR = articleService.readFullCR();
        model.addAttribute("listArticleCR", allArticlesCR);
        List<Article> allArticles = articleService.readFullEC();
        //Liste des article envoyée à la page html, eventuellement filtrée dans la fonction articleFiltering
        model.addAttribute("listArticle", articleFiltering(allArticles));
        //Envoi la list des catégories pour le formulaire de recherche
        model.addAttribute("listCategory", categoryService.getAll());
        //Envoi les param du formulaire dans l'objet "searching"
        model.addAttribute("searching", searching);
        return "index";
    }

    //Quand l'utilisateur clic sur "rechercher", cette fonction est appelée,
    //elle contient le résultat du "search"
    @PostMapping("/search")
    public ModelAndView searchArticle(@ModelAttribute Searching inputSearching) throws SQLException{
        //memorisation de la configuration de la recherche
        searching.setCategory(inputSearching.getCategory());
        return  new ModelAndView("redirect:/");
    }

    private List<Article> articleFiltering(List<Article> allArticle){
        //On regarde si une catégorie a été selctionnée, et si différente de NULL(NULL= pas de filtrage)
        if (searching.getCategory() != null && !searching.getCategory().equals("NULL")){
            //Une catégorie a été selectionnée : filtrage des article en fonction de leur catégorie
            return allArticle.stream()
                    .filter(a -> a.getCategory().getIdCategory() == Long.parseLong(searching.getCategory())).toList();
        }
        return allArticle;
    }
}
