package org.example.accounts.controllers.account;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.accounts.dtos.account.AccountRequestDTO;
import org.example.accounts.dtos.account.AccountResponseDTO;
import org.example.accounts.services.account.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/{email}")
    public ResponseEntity<AccountResponseDTO> getAccountByEmail(@PathVariable String email) {
        return ResponseEntity.ok(accountService.getAccountByEmail(email));
    }

    @PutMapping("/{email}")
    public ResponseEntity<AccountResponseDTO> updateAccount(
            @PathVariable String email,
            @Valid @RequestBody AccountRequestDTO accountRequestDTO) {
        return ResponseEntity.ok(accountService.updateAccount(email, accountRequestDTO));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String email) {
        accountService.deleteAccount(email);
        return ResponseEntity.noContent().build();
    }
}
