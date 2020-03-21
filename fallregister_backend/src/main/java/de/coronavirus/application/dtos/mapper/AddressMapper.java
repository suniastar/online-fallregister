package de.coronavirus.application.dtos.mapper;

import de.coronavirus.application.dtos.response.AddressResponse;
import de.coronavirus.application.dtos.service.AddressDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressResponse toResponse(AddressDTO addressDTO);
    List<AddressResponse> toResponseList(List<AddressDTO> addressDTOList);
}
