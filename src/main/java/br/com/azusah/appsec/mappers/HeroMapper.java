package br.com.azusah.appsec.mappers;

import br.com.azusah.appsec.models.Hero;
import br.com.azusah.appsec.repositories.entities.HeroEntity;
import org.springframework.stereotype.Service;

@Service
public class HeroMapper {

    public Hero entityToModel(HeroEntity entity) {
        return Hero.builder()
                .id(entity.getId())
                .name(entity.getName())
                .company(entity.getCompany())
                .build();
    }

    public HeroEntity modelToEntity(Hero hero) {
        return HeroEntity.builder()
                .name(hero.getName())
                .company(hero.getCompany())
                .build();
    }

}
