package org.example.accounts.dtos.account;

import org.example.accounts.dtos.user.UserResponseDTO;

public record AccountResponseDTO(
        String email,
        UserResponseDTO user
) {
}
