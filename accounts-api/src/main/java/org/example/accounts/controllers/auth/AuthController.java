package org.example.accounts.controllers.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.accounts.dtos.auth.LoginRequestDTO;
import org.example.accounts.dtos.auth.LoginResponseDTO;
import org.example.accounts.dtos.account.AccountRequestDTO;
import org.example.accounts.dtos.account.AccountResponseDTO;
import org.example.accounts.security.jwt.JwtUtil;
import org.example.accounts.services.account.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
         authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );
        String token = jwtUtil.generateToken(request.email());
        return ResponseEntity.ok(new LoginResponseDTO(token, 3600000));
    }

    @PostMapping("/register")
    public ResponseEntity<AccountResponseDTO> register(@Valid @RequestBody AccountRequestDTO request) {
        return ResponseEntity.ok(accountService.createAccount(request));
    }
}
