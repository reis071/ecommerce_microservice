package org.example.accounts.services.account;

import lombok.RequiredArgsConstructor;
import org.example.accounts.dtos.account.AccountRequestDTO;
import org.example.accounts.dtos.account.AccountResponseDTO;
import org.example.accounts.mapppers.account.AccountMapper;
import org.example.accounts.models.accounts.AccountModel;
import org.example.accounts.models.user.UserModel;
import org.example.accounts.repositories.accounts.AccountRepository;
import org.example.accounts.services.address.AddressService;
import org.example.accounts.services.user.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final UserService userService;
    private final AddressService addressService;
    private final PasswordEncoder passwordEncoder;

    public List<AccountResponseDTO> getAllAccounts() {
        return accountMapper.toResponseDTOList(accountRepository.findAll());
    }

    public AccountResponseDTO getAccountByEmail(String email) {
        AccountModel accountModel = accountRepository.findById(email)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return accountMapper.toResponseDTO(accountModel);
    }

    @Transactional
    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO) {

        if (accountRepository.existsByEmail(accountRequestDTO.email())) {
            throw new RuntimeException("Email already registered: " + accountRequestDTO.email());
        }

        UserModel savedUser = userService.createUser(accountRequestDTO.user());


        AccountModel accountModel = new AccountModel();
        accountModel.setEmail(accountRequestDTO.email());
        accountModel.setPassword(passwordEncoder.encode(accountRequestDTO.password()));
        accountModel.setUser(savedUser);

        AccountModel savedAccount = accountRepository.save(accountModel);
        return accountMapper.toResponseDTO(savedAccount);

    }

    public AccountResponseDTO updateAccount(String email, AccountRequestDTO accountRequestDTO) {
        AccountModel existingAccount = accountRepository.findById(email)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (accountRequestDTO.password() != null && !accountRequestDTO.password().isEmpty()) {
            existingAccount.setPassword(passwordEncoder.encode(accountRequestDTO.password()));
        }

        if (accountRequestDTO.user() != null) {
            UserModel user = existingAccount.getUser();
            user.setName(accountRequestDTO.user().name());
            user.setLastName(accountRequestDTO.user().lastName());
            user.setCpf(accountRequestDTO.user().cpf());
            user.setBirthDate(accountRequestDTO.user().birthDate());


            if (accountRequestDTO.user().address() != null) {
                addressService.createAddress(accountRequestDTO.user().address());
            }

            userService.createUser(accountRequestDTO.user());
        }

        AccountModel updatedAccount = accountRepository.save(existingAccount);
        return accountMapper.toResponseDTO(updatedAccount);
    }

    public void deleteAccount(String email) {
        accountRepository.deleteById(email);
    }
}

