package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.InfectedDto;
import de.coronavirus.domain.model.Infected;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InfectedRepository extends JpaRepository<Infected, Long> {

    List<InfectedDto> findAllDtoBy();

    Optional<InfectedDto> findDtoById(Long id);

}
