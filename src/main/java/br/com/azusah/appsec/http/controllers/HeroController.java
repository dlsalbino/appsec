package br.com.azusah.appsec.http.controllers;

import br.com.azusah.appsec.http.mappers.HeroHttpMapper;
import br.com.azusah.appsec.http.payloads.HeroRequest;
import br.com.azusah.appsec.http.payloads.HeroResponse;
import br.com.azusah.appsec.models.Hero;
import br.com.azusah.appsec.services.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/heroes")
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;
    private final HeroHttpMapper heroHttpMapper;

    @GetMapping
    ResponseEntity<Collection<HeroResponse>> listHeroes() {
        Set<Hero> heroes = heroService.findAll();
        Collection<HeroResponse> heroResponses = heroes.stream()
                .sorted(Comparator.comparing(Hero::getId))
                .map(heroHttpMapper::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(heroResponses);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<HeroResponse> findById(@PathVariable(value = "id") Long id) {
        HeroResponse heroResponse = heroHttpMapper.convert(heroService.findById(id));
        return ResponseEntity.ok(heroResponse);
    }

    @PostMapping
    ResponseEntity<HeroResponse> create(@Valid @RequestBody HeroRequest heroRequest) {
        Hero hero = heroService.insert(heroHttpMapper.convert(heroRequest));
        return ResponseEntity.ok(heroHttpMapper.convert(hero));
    }
}
