package fr.eni.encheres.controller;

import fr.eni.encheres.entity.Article;
import fr.eni.encheres.entity.Proposal;
import fr.eni.encheres.entity.User;
import fr.eni.encheres.entity.dto.CreateArticleDTO;
import fr.eni.encheres.service.*;
import fr.eni.encheres.service.exceptions.ProposalException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
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
    public String displaySell(Model model) {
        CreateArticleDTO articleDTO = new CreateArticleDTO();

        // Donne les valeurs de l'adresse de l'user
        long idSeller = userService.getIdLoggedUser();
        User userLogged = this.userService.readById(idSeller);

        articleDTO.setSeller(userLogged);
        articleDTO.setAddress(userLogged.getAddress());
        articleDTO.setZipCode(userLogged.getZipCode());
        articleDTO.setCity(userLogged.getCity());

        model.addAttribute("articleDTO", articleDTO);
        model.addAttribute("categoryList", this.categoryService.getAll());
        model.addAttribute("addressByPseudo", userLogged);

        return "vendre";
    }

    @PostMapping("/vendre/add")
    public String createArticle(@Valid @ModelAttribute("articleDTO") CreateArticleDTO articleDTO,
                                BindingResult bindingResult,
                                Model model,
                                RedirectAttributes redirectAttributes) {

        // Validation manuelle : endingDate > beginningDate
        if (articleDTO.getBeginningDate() != null &&
                articleDTO.getEndingDate() != null &&
                !articleDTO.getEndingDate().isAfter(articleDTO.getBeginningDate())) {

            bindingResult.rejectValue("endingDate",
                    "error.endingDate",
                    "La date de fin doit être postérieure à la date de début");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", this.categoryService.getAll());
            long idSeller = userService.getIdLoggedUser();
            model.addAttribute("addressByPseudo", this.userService.readById(idSeller));
            return "vendre";
        }

        try {
            articleService.createArticleDTO(articleDTO);
            redirectAttributes.addFlashAttribute("successMessage",
                    "Votre article a été mis en vente avec succès !");
            return "redirect:/mes-ventes#ventes-crees";

        } catch (Exception e) {
            model.addAttribute("errorMessage", "Une erreur est survenue : " + e.getMessage());
            model.addAttribute("categoryList", this.categoryService.getAll());
            long idSeller = userService.getIdLoggedUser();
            model.addAttribute("addressByPseudo", this.userService.readById(idSeller));
            return "vendre";
        }
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable("id") final long id, Model model, Proposal proposal) {
        //récup des détails d'un article
        Article article = articleService.readById(id);
        List<Proposal> listProposal = proposalService.readProposalByIdArticle(id);
        model.addAttribute("article", article);
        model.addAttribute("listProposal", listProposal);
        model.addAttribute("newProposal", new Proposal());
        //Recup de la date du jour pour afficher ou non la box d'enchères
        model.addAttribute("localDateTime", LocalDateTime.now());
        //Recup de l'id utilisateur connecté pour afficher son portefeuille
        model.addAttribute("userConnected", this.userService.readById(userService.getIdLoggedUser()));
        model.addAttribute("idUserConnected", userService.getIdLoggedUser());
        //Affichage de la page détails d'un article
        return "details";
    }

    @PostMapping("/article/{id}/addProposal")
    public String addProposal(@PathVariable("id") long id,
                              @ModelAttribute("newProposal") Proposal newProposal,
                              BindingResult bindingResult,
                              Model model,
                              RedirectAttributes redirectAttributes) {

        Article article = articleService.readById(id);
        List<Proposal> listProposal = proposalService.readProposalByIdArticle(id);
        model.addAttribute("article", article);
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("listProposal", listProposal);
        model.addAttribute("userConnected", userService.readById(userService.getIdLoggedUser()));
        model.addAttribute("idUserConnected", userService.getIdLoggedUser());

        if (bindingResult.hasErrors()) {
            return "details";
        }

        try {
            proposalService.createProposal(id, newProposal.getPointProposal());
            redirectAttributes.addFlashAttribute("successMessage", "Votre proposition a été enregistrée avec succès !");
            return "redirect:/article/" + id;
        } catch (ProposalException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "details";
        }
    }


}