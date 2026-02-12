package org.example.accounts.dtos.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.accounts.dtos.address.AddressRequestDTO;

import java.time.LocalDateTime;

public record UserRequestDTO(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Last name is required")
        String lastName,

        @NotBlank(message = "CPF is required")
        String cpf,

        @NotNull(message = "Birth date is required")
        LocalDateTime birthDate,

        AddressRequestDTO address
) {
}
