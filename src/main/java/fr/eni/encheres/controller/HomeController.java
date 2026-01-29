package fr.eni.encheres.controller;


import fr.eni.encheres.entity.dto.CreateArticleDTO;
import fr.eni.encheres.service.ArticleService;
import fr.eni.encheres.service.CategoryService;
import fr.eni.encheres.service.DeliveryAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    ArticleService articleService;
    DeliveryAddressService deliveryAddressService;
    CategoryService categoryService;

    public HomeController(ArticleService articleService, CategoryService categoryService, DeliveryAddressService deliveryAddressService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
        this.deliveryAddressService = deliveryAddressService;
    }

    @GetMapping("/vendre")
    public String displayVendre(Model model, CreateArticleDTO articleDTO) {
        model.addAttribute("articleDTO", articleDTO);
        model.addAttribute("addressList", this.deliveryAddressService.readAll());
        model.addAttribute("categoryList", this.categoryService.getAll());
        return "vendre";
    }

    @PostMapping("/vendre/add")
    public String addArticleVendre(@ModelAttribute("articleDTO") CreateArticleDTO articleDTO) {
        System.out.println(articleDTO);
        articleService.createArticleDTO(articleDTO);
        return "redirect:/";
    }

    @GetMapping("/mes-encheres")
    public String displayMesEncheres() {
        return "mes-encheres";
    }



}
