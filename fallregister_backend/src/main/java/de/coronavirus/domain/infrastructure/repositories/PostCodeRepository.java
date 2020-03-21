package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.PostCodeDTO;
import de.coronavirus.domain.model.PostCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostCodeRepository extends JpaRepository<PostCode, Long> {

    List<PostCodeDTO> findAllDtoBy();
    Optional<PostCodeDTO> findDtoById(Long id);
}
