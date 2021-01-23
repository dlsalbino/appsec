package br.com.azusah.appsec.services;

import br.com.azusah.appsec.mappers.HeroMapper;
import br.com.azusah.appsec.models.Hero;
import br.com.azusah.appsec.repositories.HeroRepository;
import br.com.azusah.appsec.repositories.entities.HeroEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HeroServiceTest {

    @InjectMocks
    private HeroService heroService;

    @Mock
    private HeroMapper heroMapper;

    @Mock
    private HeroRepository repository;

    @Test
    @DisplayName("")
    void findAll() {
    }

    @Test
    @DisplayName("")
    void findById() {
    }

    @Test
    @DisplayName("should persist a hero")
    void insert() {

        //given
        Hero heroExpected = Hero.builder()
                .id(1L)
                .name("HeroName")
                .company("HeroCompany")
                .build();

        Hero model = Hero.builder()
                .name("HeroName")
                .company("HeroCompany")
                .build();

        HeroEntity heroEntity = HeroEntity.builder()
                .id(1L)
                .name("HeroName")
                .company("HeroCompany")
                .build();

        when(repository.insert(any(HeroEntity.class))).thenReturn(heroEntity);
        when(heroMapper.modelToEntity(any(Hero.class))).thenReturn(heroEntity);
        when(heroMapper.entityToModel(any(HeroEntity.class))).thenReturn(heroExpected);

        //when
        Hero heroActual = heroService.insert(model);

        //then
        assertThat(heroActual)
                .usingRecursiveComparison()
                .isEqualTo(heroExpected);
    }
}