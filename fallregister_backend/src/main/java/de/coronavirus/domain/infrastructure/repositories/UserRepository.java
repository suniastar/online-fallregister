package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.UserDto;
import de.coronavirus.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByNameAndPassword(String name, String password);

    List<UserDto> findAllDtoBy();

    Optional<UserDto> findDtoByName(String name);
}
