package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.UserDTO;
import de.coronavirus.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    List<UserDTO> findAllDtoBy();
    Optional<UserDTO> findDtoById();
}
