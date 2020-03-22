package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.CityDto;
import de.coronavirus.domain.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

    List<CityDto> findAllDtoBy();
    Optional<CityDto> findDtoById(Long id);
    List<CityDto> findTop10ByNameStartsWith(String partial);

}
