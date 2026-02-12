package org.example.accounts.mapppers.user;

import org.example.accounts.mapppers.address.AddressMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.example.accounts.dtos.user.UserRequestDTO;
import org.example.accounts.dtos.user.UserResponseDTO;
import org.example.accounts.models.user.UserModel;


@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface UserMapper {


    UserResponseDTO toResponseDTO(UserModel userModel);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    UserModel toEntity(UserRequestDTO userRequestDTO);

}
