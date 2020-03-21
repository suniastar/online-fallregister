package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.DiagnosisDTO;
import de.coronavirus.domain.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {

    List<DiagnosisDTO> findAllDtoBy();
    Optional<DiagnosisDTO> findDtoById(Long id);
}
