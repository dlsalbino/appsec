package br.com.azusah.appsec.services;

import br.com.azusah.appsec.models.Hero;
import br.com.azusah.appsec.repositories.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final HeroRepository heroRepository;

    public Set<Hero> findAll(){
        return heroRepository.findAll().stream().map(heroEntity -> {
            return Hero.builder()
                    .id(heroEntity.getId())
                    .name(heroEntity.getName())
                    .company(heroEntity.getCompany())
                    .build();
        }).collect(Collectors.toSet());
    }

}
