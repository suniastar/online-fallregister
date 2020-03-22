package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.DetectorDto;
import de.coronavirus.domain.model.Address;
import de.coronavirus.domain.model.Detector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetectorRepository extends JpaRepository<Detector, Long> {

    Optional<Detector> findByNameAndAddress(String name, Address address);

    List<DetectorDto> findAllDtoBy();

    Optional<DetectorDto> findDtoById(Long id);
}
