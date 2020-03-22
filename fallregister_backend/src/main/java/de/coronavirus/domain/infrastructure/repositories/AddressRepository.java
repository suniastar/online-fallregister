package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.AddressDto;
import de.coronavirus.domain.model.Address;
import de.coronavirus.domain.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByStreetAndHouseNumber(Street street, String number);

    List<AddressDto> findAllDtoBy();

    Optional<AddressDto> findDtoById(Long Id);
}
