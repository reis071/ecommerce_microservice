package org.example.accounts.dtos.address;

public record AddressResponseDTO(
        String cep,
        String street,
        String number,
        String neighborhood,
        String city,
        String state
) {
}
