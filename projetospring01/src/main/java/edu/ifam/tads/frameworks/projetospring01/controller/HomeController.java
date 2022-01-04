package edu.ifam.tads.frameworks.projetospring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @ResponseBody
    @RequestMapping("/")
    public String index(){
        System.out.println("Funcionou!");
        return "Funcionou no Browser";
    }
}
