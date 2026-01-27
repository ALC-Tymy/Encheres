package fr.eni.encheres.controller;

import fr.eni.encheres.entity.User;
import fr.eni.encheres.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String pushInscription(@ModelAttribute("newUser") User user){
        this.userService.createUser(user);
        return "redirect:/connexion";
    }

}
