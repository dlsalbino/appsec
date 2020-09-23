package br.com.azusah.appsec.controllers;

import br.com.azusah.appsec.models.Hero;
import br.com.azusah.appsec.services.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/heroes")
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;

    @GetMapping
    ResponseEntity<Set<Hero>> listHeroes() {
        Set<Hero> heroes = heroService.findAll();
        return ResponseEntity.ok(heroes);
    }
}
