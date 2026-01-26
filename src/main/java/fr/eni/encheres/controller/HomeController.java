package fr.eni.encheres.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String displayIndex() {
        return "index.html";
    }


}
