package de.coronavirus.domain.infrastructure.repositories;

import de.coronavirus.application.dtos.service.TokenDto;
import de.coronavirus.domain.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByValueAndValidUntilAfter(String value, Date date);

    List<TokenDto> findAllDtoBy();

    Optional<TokenDto> findDtoById(Long id);
}
