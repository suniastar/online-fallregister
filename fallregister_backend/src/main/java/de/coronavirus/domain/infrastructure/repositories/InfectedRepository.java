package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.InfectedDTO;
import de.coronavirus.domain.model.Infected;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InfectedRepository extends JpaRepository<Infected, Long> {

    List<InfectedDTO> findAllDtoBy();
    Optional<InfectedDTO> findDtoById();
}
