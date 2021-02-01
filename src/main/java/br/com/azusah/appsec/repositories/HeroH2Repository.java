package br.com.azusah.appsec.repositories;

import br.com.azusah.appsec.repositories.entities.HeroEntity;
import org.springframework.data.repository.CrudRepository;

public interface HeroH2Repository extends CrudRepository<HeroEntity, Long> {
}
