package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.StreetDTO;
import de.coronavirus.domain.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StreetRepository extends JpaRepository<Street, Long> {

    List<StreetDTO> findAllDtoBy();
    Optional<StreetDTO> findDtoById(Long id);
}
