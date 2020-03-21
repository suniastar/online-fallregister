package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.DetectorDTO;
import de.coronavirus.domain.model.Detector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DetectorRepository extends JpaRepository<Detector,Long> {

    List<DetectorDTO> findAllDtoBy();
    Optional<DetectorDTO> findDtoById(Long id);
}
