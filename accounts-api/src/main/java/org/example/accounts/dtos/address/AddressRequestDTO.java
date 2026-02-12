package org.example.accounts.dtos.address;

import jakarta.validation.constraints.NotBlank;

public record AddressRequestDTO(
        @NotBlank(message = "CEP is required")
        String cep,

        String street,

        @NotBlank(message = "Number is required")
        String number,

        String neighborhood,

        String city,

        String state
) {
}
