package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.LaboratoryDto;
import de.coronavirus.domain.model.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory,Long> {

    List<LaboratoryDto> findAllDtoBy();

    Optional<LaboratoryDto> findDtoById(Long id);
    List<LaboratoryDto> findTop10ByNameStartsWith(String partial);
}
