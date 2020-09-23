package br.com.azusah.appsec.repositories;

import br.com.azusah.appsec.repositories.entities.HeroEntity;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Data
public class HeroRepository {

    private static HeroEntity hero;
    private static Set<HeroEntity> heroes = new HashSet<>();

    static {
        heroes.add(HeroEntity.builder().id(1L).name("Wolverine").company("Marvel").build());
        heroes.add(HeroEntity.builder().id(2L).name("Rogue").company("Marvel").build());
        heroes.add(HeroEntity.builder().id(3L).name("Dark Phoenix").company("Marvel").build());
        heroes.add(HeroEntity.builder().id(4L).name("Storm").company("Marvel").build());
        heroes.add(HeroEntity.builder().id(5L).name("Black Widow").company("Marvel").build());
        heroes.add(HeroEntity.builder().id(6L).name("Nick Fury").company("Marvel").build());
        heroes.add(HeroEntity.builder().id(7L).name("Cyclops").company("Marvel").build());
        heroes.add(HeroEntity.builder().id(8L).name("Magneto").company("Marvel").build());
        heroes.add(HeroEntity.builder().id(9L).name("Thor").company("Marvel").build());
        heroes.add(HeroEntity.builder().id(10L).name("Iron Man").company("Marvel").build());
        heroes.add(HeroEntity.builder().id(11L).name("Superman").company("DC Comics").build());
        heroes.add(HeroEntity.builder().id(12L).name("Batman").company("DC Comics").build());
        heroes.add(HeroEntity.builder().id(13L).name("Wonder Woman").company("DC Comics").build());
        heroes.add(HeroEntity.builder().id(14L).name("Aquaman").company("DC Comics").build());
        heroes.add(HeroEntity.builder().id(15L).name("Flash").company("DC Comics").build());
    }

    public Set<HeroEntity> findAll() {
        return heroes;
    }

    public HeroEntity findById(Long id) {
        return heroes.stream()
                .filter(heroEntity -> heroEntity.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public HeroEntity findByName(String name) {
        return heroes.stream()
                .filter(heroEntity -> heroEntity.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public static Set<HeroEntity> findByCompany(String company) {
        return heroes.stream()
                .filter(heroEntity -> heroEntity.getCompany().equals(company))
                .collect(Collectors.toSet());
    }
}
