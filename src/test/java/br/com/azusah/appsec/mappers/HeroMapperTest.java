package br.com.azusah.appsec.mappers;

import br.com.azusah.appsec.models.Hero;
import br.com.azusah.appsec.repositories.entities.HeroEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class HeroMapperTest {

    @InjectMocks
    private HeroMapper heroMapper;

    @Test
    @DisplayName("should convert an entity in a model")
    void entityToModel() {

        //given
        Hero heroExpected = Hero.builder()
                .id(1L)
                .name("HeroName")
                .company("HeroCompany")
                .build();

        HeroEntity entity = HeroEntity.builder()
                .id(1L)
                .name("HeroName")
                .company("HeroCompany")
                .build();

        //when
        Hero heroActual = heroMapper.entityToModel(entity);

        //then
        assertThat(heroActual)
                .isNotNull()
                .isExactlyInstanceOf(Hero.class)
                .isEqualToComparingFieldByField(heroExpected);
    }

    @Test
    void modelToEntity() {

        //given
        HeroEntity heroExpected = HeroEntity.builder()
                .name("HeroName")
                .company("HeroCompany")
                .build();

        Hero model = Hero.builder()
                .id(1L)
                .name("HeroName")
                .company("HeroCompany")
                .build();

        //when
        HeroEntity heroActual = heroMapper.modelToEntity(model);

        //then
        assertThat(heroActual)
                .isNotNull()
                .isExactlyInstanceOf(HeroEntity.class)
                .isEqualToComparingFieldByField(heroExpected);

    }

}