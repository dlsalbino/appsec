package br.com.azusah.appsec.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/heroes")
public class HeroController {

    @GetMapping
    String listHeroes(){
        return "Wolverine";
    }
}
