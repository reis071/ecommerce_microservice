package org.example.accounts.security;

import lombok.RequiredArgsConstructor;
import org.example.accounts.models.accounts.AccountModel;
import org.example.accounts.repositories.accounts.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AccountModel account = accountRepository.findById(email)
                .orElseThrow(() -> new UsernameNotFoundException("Account not found with email: " + email));

        return User
                .withUsername(account.getEmail())
                .password(account.getPassword())
                .authorities("USER")
                .build();
    }
}
