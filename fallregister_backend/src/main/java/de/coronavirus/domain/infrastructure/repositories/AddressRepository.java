package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.AddressDTO;
import de.coronavirus.domain.model.Accommodation;
import de.coronavirus.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    List<AddressDTO> findAllDtoBy();
    Optional<AddressDTO> findDtoById(Long Id);
}
