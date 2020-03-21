package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.AccommodationDTO;
import de.coronavirus.domain.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation,Long> {

    List<AccommodationDTO> findAllDtoBy();
    Optional<AccommodationDTO> findDtoById(Long id);
}
