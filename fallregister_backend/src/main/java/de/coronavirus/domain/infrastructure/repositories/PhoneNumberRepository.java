package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.PhoneNumberDto;
import de.coronavirus.domain.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Long> {

    List<PhoneNumberDto> findAllDtoBy();

    Optional<PhoneNumberDto> findDtoById(Long id);
}