package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.CountryDto;
import de.coronavirus.domain.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    List<CountryDto> findAllDtoBy();

    Optional<CountryDto> findDtoById(Long id);
}
