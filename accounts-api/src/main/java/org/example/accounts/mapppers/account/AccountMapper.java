package org.example.accounts.mapppers.account;

import org.example.accounts.mapppers.address.AddressMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.example.accounts.dtos.account.AccountResponseDTO;
import org.example.accounts.models.accounts.AccountModel;
import org.example.accounts.mapppers.user.UserMapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, AddressMapper.class})
public interface AccountMapper {

    AccountResponseDTO toResponseDTO(AccountModel accountModel);

    List<AccountResponseDTO> toResponseDTOList(List<AccountModel> accounts);

}
