package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.EmailAddressDto;
import de.coronavirus.domain.model.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailAddressRepository extends JpaRepository<EmailAddress, Long> {

    List<EmailAddressDto> findAllDtoBy();
    Optional<EmailAddressDto> findDtoById(Long id);
}
