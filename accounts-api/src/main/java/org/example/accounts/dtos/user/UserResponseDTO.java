package org.example.accounts.dtos.user;

import org.example.accounts.dtos.address.AddressResponseDTO;

public record UserResponseDTO(
        String name,
        String lastName,
        AddressResponseDTO address
) {
}
