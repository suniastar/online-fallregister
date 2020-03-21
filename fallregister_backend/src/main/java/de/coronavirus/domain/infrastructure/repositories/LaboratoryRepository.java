package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.LaboratoryDTO;
import de.coronavirus.domain.model.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LaboratoryRepository extends JpaRepository<Laboratory,Long> {

    List<LaboratoryDTO> findAllDtoBy();
    Optional<LaboratoryDTO> findDtoById(Long id);
}
