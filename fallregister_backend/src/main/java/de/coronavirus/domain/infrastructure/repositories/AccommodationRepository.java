package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.AccommodationDto;
import de.coronavirus.domain.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    Optional<Accommodation> findByName(String name);

    List<AccommodationDto> findAllDtoBy();

    Optional<AccommodationDto> findDtoById(Long id);
}
