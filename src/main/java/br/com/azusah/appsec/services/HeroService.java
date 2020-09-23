package br.com.azusah.appsec.services;

import br.com.azusah.appsec.mappers.HeroMapper;
import br.com.azusah.appsec.models.Hero;
import br.com.azusah.appsec.repositories.HeroRepository;
import br.com.azusah.appsec.repositories.entities.HeroEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final HeroRepository heroRepository;
    private final HeroMapper heroMapper;

    public Set<Hero> findAll() {
        return heroRepository.findAll().stream().map(heroEntity -> {
            return Hero.builder()
                    .id(heroEntity.getId())
                    .name(heroEntity.getName())
                    .company(heroEntity.getCompany())
                    .build();
        }).collect(Collectors.toSet());
    }

    public Hero findOne(Long id) {
        Optional<HeroEntity> optHeroEntity = Optional.ofNullable(heroRepository.findById(id));
        return optHeroEntity.map(heroMapper::entityToModel).orElseThrow();

    }
}
