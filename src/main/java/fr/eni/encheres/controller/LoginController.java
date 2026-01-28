package fr.eni.encheres.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/connexion")
    public String connexion() {
        return "connexion";
    }

    /**
     * Affiche la page contenant les informations de l'utilisateur connecté.
     * Récupère le pseudo depuis l'objet Authentication et affiche un message
     * de type : "Bonjour <Pseudo>" dans la vue.
     *
     * @param authentication objet Spring Security contenant l'utilisateur authentifié
     * @return le nom de la vue "display-user"
     */
    @GetMapping("/display-user")
    public String displayUser(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        assert userDetails != null;
        String pseudo = userDetails.getUsername();
        return "display-user";
    }

}
