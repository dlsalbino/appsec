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
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/heroes")
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;
    private final HeroHttpMapper heroHttpMapper;

    @GetMapping
    ResponseEntity<Set<HeroResponse>> listHeroes() {
        Set<Hero> heroes = heroService.findAll();
        Set<HeroResponse> heroResponses = heroes.stream().map(hero -> heroHttpMapper.convert(hero)).collect(Collectors.toSet());
        return ResponseEntity.ok(heroResponses);
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
