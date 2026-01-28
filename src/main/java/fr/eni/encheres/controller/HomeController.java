package fr.eni.encheres.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
//
//    @GetMapping("/")
//    public String displayIndex() {
//        return "index";
//    }

    @GetMapping("/vendre")
    public String displayVendre() {
        return "vendre";
    }

    @GetMapping("/mes-ventes")
    public String displayMesVentes() {
        return "mes-ventes";
    }

    @GetMapping("/mes-encheres")
    public String displayMesEncheres() {
        return "mes-encheres";
    }

    @GetMapping("/mon-compte")
    public String displayMonCompte() {
        return "mon-compte";
    }





}
