package br.com.azusah.appsec.http.controllers;

import br.com.azusah.appsec.http.mappers.HeroHttpMapper;
import br.com.azusah.appsec.http.payloads.HeroRequest;
import br.com.azusah.appsec.http.payloads.HeroResponse;
import br.com.azusah.appsec.models.Hero;
import br.com.azusah.appsec.services.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/heroes")
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;
    private final HeroHttpMapper heroHttpMapper;

    @GetMapping
    ResponseEntity<Set<Hero>> listHeroes() {
        Set<Hero> heroes = heroService.findAll();
        return ResponseEntity.ok(heroes);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Hero> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(heroService.findById(id));
    }

    @PostMapping
    ResponseEntity<HeroResponse> create(@RequestBody HeroRequest heroRequest) {
        Hero hero = heroService.insert(heroHttpMapper.convert(heroRequest));
        return ResponseEntity.ok(heroHttpMapper.convert(hero));
    }
}
