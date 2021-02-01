package br.com.azusah.appsec.services;

import br.com.azusah.appsec.mappers.HeroMapper;
import br.com.azusah.appsec.models.Hero;
import br.com.azusah.appsec.repositories.HeroH2Repository;
import br.com.azusah.appsec.repositories.entities.HeroEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final HeroH2Repository h2Repository;
    private final HeroMapper heroMapper;

    public Set<Hero> findAll() {

        List<HeroEntity> entityList = new ArrayList<>();
        Iterable<HeroEntity> all = h2Repository.findAll();
        all.forEach(heroEntity -> entityList.add(heroEntity));

        return entityList.stream()
                .map(heroEntity -> heroMapper.entityToModel(heroEntity))
                .collect(Collectors.toSet());
    }

    public Hero findById(Long id) {
        return h2Repository.findById(id)
                .map(heroMapper::entityToModel)
                .orElse(Hero.builder().build());
    }

    public Hero insert(Hero hero) {
        HeroEntity entity = h2Repository.save(heroMapper.modelToEntity(hero));
        return heroMapper.entityToModel(entity);
    }
}
