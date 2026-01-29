package fr.eni.encheres.controller;

import fr.eni.encheres.entity.User;
import fr.eni.encheres.service.ArticleService;
import fr.eni.encheres.service.ProposalService;
import fr.eni.encheres.service.UserService;
import fr.eni.encheres.service.exceptions.SignUpException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final ProposalService proposalService;
    UserService userService;
    ArticleService articleService;

    public UserController(UserService userService, ArticleService articleService, ProposalService proposalService) {
        this.userService = userService;
        this.articleService = articleService;
        this.proposalService = proposalService;
    }

    @GetMapping("/mon-compte")
    public String displayMonCompte(Model model) {
        model.addAttribute("userConnected", userService.readById(userService.getIdLoggedUser()));
        return "mon-compte";
    }

    @GetMapping("/mon-compte/update")
    public String displayUpdateCompte(Model model){
        model.addAttribute("userConnected", userService.readById(userService.getIdLoggedUser()));
        return "update-compte";
    }

    @PostMapping("/mon-compte/update-post")
    public String postUpdateCompte(@Valid @ModelAttribute("userConnected") User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "update-compte";
        }

        try {
            this.userService.updateUser(user);
        } catch (SignUpException e){
            bindingResult.addError(new ObjectError("globalError", e.getMessage()));
            return "update-compte";
        }

        return "redirect:/mon-compte";
    }

    @GetMapping("/mon-compte/desactivate")
    public String desactivateAccount(HttpServletRequest request, HttpServletResponse response){
        userService.desactivateUser(userService.getIdLoggedUser());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }

    @GetMapping("/mes-ventes")
    public String displayMesVentes(Model model) {
        model.addAttribute("articleCRList", articleService.readArticleCRByIdSeller(userService.getIdLoggedUser()));
//        model.addAttribute("articleECList", articleService.readArticleECByIdSeller(userService.getIdLoggedUser()));
        return "mes-ventes";
    }

    @GetMapping("/mes-encheres")
    public String displayMesEncheres(Model model){
        model.addAttribute("proposalECList", proposalService.readProposalECByIdUser(userService.getIdLoggedUser()));
        model.addAttribute("proposalVDLVList", proposalService.readProposalVDLVByIdUser(userService.getIdLoggedUser()));
        return "mes-encheres";
    }

}
