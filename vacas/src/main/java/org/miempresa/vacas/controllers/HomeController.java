package org.miempresa.vacas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "INDEX";
    }

    @GetMapping ("/error")
    public String error(){return "/CRUD/error";}
}
