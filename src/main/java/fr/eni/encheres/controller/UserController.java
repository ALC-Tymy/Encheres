package fr.eni.encheres.controller;

import fr.eni.encheres.entity.User;
import fr.eni.encheres.service.UserService;
import fr.eni.encheres.service.exceptions.SignUpException;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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

}
