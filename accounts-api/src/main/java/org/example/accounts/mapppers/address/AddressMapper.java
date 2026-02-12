package org.example.accounts.mapppers.address;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.example.accounts.dtos.address.AddressRequestDTO;
import org.example.accounts.dtos.address.AddressResponseDTO;
import org.example.accounts.models.address.AddressModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    // Model -> Response DTO
    @Mapping(source = "town", target = "city")
    AddressResponseDTO toResponseDTO(AddressModel addressModel);

    // Request DTO -> Model
    @Mapping(source = "city", target = "town")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    AddressModel toEntity(AddressRequestDTO addressRequestDTO);

    // Collections
    List<AddressResponseDTO> toResponseDTOList(List<AddressModel> addressModels);
}
