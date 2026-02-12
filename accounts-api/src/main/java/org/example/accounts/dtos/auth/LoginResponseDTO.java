package org.example.accounts.dtos.auth;

public record LoginResponseDTO(
        String token,
        long expiresInMillis
) {
}
