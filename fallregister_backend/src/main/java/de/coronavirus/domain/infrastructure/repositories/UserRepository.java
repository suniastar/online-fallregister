package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.UserDTO;
import de.coronavirus.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<UserDTO> findAllDtoBy();

    Optional<UserDTO> findDtoByName(String name);
}
