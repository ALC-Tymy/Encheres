package fr.eni.encheres.controller;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.entity.Proposal;
import fr.eni.encheres.entity.User;
import fr.eni.encheres.entity.dto.CreateArticleDTO;
import fr.eni.encheres.service.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {

    private final ProposalService proposalService;
    ArticleService articleService;
    DeliveryAddressService deliveryAddressService;
    CategoryService categoryService;
    UserService userService;

    public ArticleController(ArticleService articleService, DeliveryAddressService deliveryAddressService, CategoryService categoryService, UserService userService, ProposalService proposalService) {
        this.articleService = articleService;
        this.deliveryAddressService = deliveryAddressService;
        this.categoryService = categoryService;
        this.userService = userService;
        this.proposalService = proposalService;
    }

    @GetMapping("/vendre")
    public String displaySell(Model model, CreateArticleDTO articleDTO) {

        //donne-les valeur de l'adresse de l'user
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
        if (bindingResult.hasErrors()) {
            return "vendre";
        }

        articleService.createArticleDTO(articleDTO);
        return "redirect:/";
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable("id") final long id, Model model, Proposal proposal) {
        //récup des détails d'un article
        Article article = articleService.readById(id);
        List<Proposal> listProposal = proposalService.readProposalByIdArticle(id);
        model.addAttribute("article", article);
        model.addAttribute("listProposal", listProposal);
        model.addAttribute("newProposal", new Proposal());
        //Recup de l'id utilisateur connecté pour afficher son portefeuille
        model.addAttribute("userConnected", this.userService.readById(userService.getIdLoggedUser()));
        //Affichage de la page détails d'un article
        return "details";
    }

    @PostMapping("/article/{id}/addProposal")
    public String addProposal(@ModelAttribute("newProposal") Proposal newProposal,
                              @PathVariable("id") long id) {
        proposalService.createProposal(id, newProposal.getPointProposal());
        return "redirect:/mes-encheres";
    }
}