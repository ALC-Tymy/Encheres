package fr.eni.encheres.controller;

import fr.eni.encheres.entity.User;
import fr.eni.encheres.entity.dto.CreateArticleDTO;
import fr.eni.encheres.entity.Article;
import fr.eni.encheres.service.ArticleService;
import fr.eni.encheres.service.CategoryService;
import fr.eni.encheres.service.DeliveryAddressService;
import fr.eni.encheres.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ArticleController {

    ArticleService articleService;
    DeliveryAddressService deliveryAddressService;
    CategoryService categoryService;
    UserService userService;

    public ArticleController(ArticleService articleService, DeliveryAddressService deliveryAddressService, CategoryService categoryService, UserService userService) {
        this.articleService = articleService;
        this.deliveryAddressService = deliveryAddressService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/vendre")
    public String displaySell(Model model, CreateArticleDTO articleDTO) {

        //donne les valeur de l'adresse du user
        long idSeller = userService.getIdLoggedUser();
        User Userlogged = this.userService.readById(idSeller);
        articleDTO.setSeller(Userlogged);
        articleDTO.setAddress(Userlogged.getAddress());
        articleDTO.setZipCode(Userlogged.getZipCode());
        articleDTO.setCity(Userlogged.getCity());

        model.addAttribute("articleDTO", articleDTO);
        model.addAttribute("categoryList", this.categoryService.getAll());
        model.addAttribute("addressByPseudo", this.userService.readById(userService.getIdLoggedUser()));
        return "vendre";
    }

    @PostMapping("/vendre/add")
    public String addArticleSell(@Valid @ModelAttribute("articleDTO") CreateArticleDTO articleDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "vendre";
        }

        articleService.createArticleDTO(articleDTO);
        return "redirect:/";
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable("id") final long id, Model model) {
        //récup des détails d'un article
        Article article = articleService.readById(id);
        model.addAttribute("article", article);
        //Affichage de la page détails d'un article
        return "details";
    }
}