package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.TokenResponse;
import de.coronavirus.application.dtos.service.TokenDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TokenMapper {

    TokenResponse toResponse(TokenDto tokenDTO);
    List<TokenResponse> toResponseList(List<TokenDto> tokenDTOList);
}