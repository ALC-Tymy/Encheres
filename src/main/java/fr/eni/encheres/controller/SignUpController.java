package fr.eni.encheres.controller;

import fr.eni.encheres.entity.User;
import fr.eni.encheres.service.UserService;
import fr.eni.encheres.service.exceptions.SignUpException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inscription")
    public String displayInscription(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("listeUsers", userService.readAll());
        return "inscription";
    }

    @PostMapping("/inscription/new")
    public String pushInscription(@ModelAttribute("newUser") User user, BindingResult bindingresult){

        if (bindingresult.hasErrors()) {
            return "inscription";
        }

        try {
            this.userService.createUser(user);
        } catch (SignUpException e){
            bindingresult.addError(new ObjectError("globalError", e.getMessage()));
            return "inscription";
        }

        return "redirect:/connexion";
    }

}
