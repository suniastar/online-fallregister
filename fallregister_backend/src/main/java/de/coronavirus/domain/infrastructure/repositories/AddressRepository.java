package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.AddressDto;
import de.coronavirus.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    List<AddressDto> findAllDtoBy();
    Optional<AddressDto> findDtoById(Long Id);
}
