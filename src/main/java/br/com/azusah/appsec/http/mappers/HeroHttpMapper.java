package br.com.azusah.appsec.http.mappers;

import br.com.azusah.appsec.http.payloads.HeroRequest;
import br.com.azusah.appsec.http.payloads.HeroResponse;
import br.com.azusah.appsec.models.Hero;
import org.springframework.stereotype.Component;

@Component
public class HeroHttpMapper {

    public Hero convert(HeroRequest request) {
        return Hero.builder()
                .name(request.getName())
                .company(request.getCompany())
                .build();
    }

    public HeroResponse convert(Hero hero) {
        return HeroResponse.builder()
                .id(hero.getId())
                .name(hero.getName())
                .company(hero.getCompany())
                .build();
    }
}
