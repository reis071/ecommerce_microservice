package org.example.accounts.dtos.viacep;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ViaCepResponseDTO(
        String cep,
        String state,
        String city,
        String neighborhood,
        String street,
        String service
) {}
