package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.StreetDto;
import de.coronavirus.domain.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {

    List<StreetDto> findAllDtoBy();

    Optional<StreetDto> findDtoById(Long id);
    List<StreetDto> findTop10ByNameStartsWithOrderByNameAsc(String partial);
}
