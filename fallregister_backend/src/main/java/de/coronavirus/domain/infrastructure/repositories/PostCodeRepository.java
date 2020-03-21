package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.PostCodeDTO;
import de.coronavirus.domain.model.PostCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostCodeRepository extends JpaRepository<PostCode, Long> {

    List<PostCodeDTO> findAllDtoBy();

    Optional<PostCodeDTO> findDtoByCode(Long code);
}
