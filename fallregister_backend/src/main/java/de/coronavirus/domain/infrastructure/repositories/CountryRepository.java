package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.CountryDTO;
import de.coronavirus.domain.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    List<CountryDTO> findAllDtoBy();
    Optional<CountryDTO> findDtoById();
}
