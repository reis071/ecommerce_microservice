package org.example.accounts.repositories.accounts;

import org.example.accounts.models.accounts.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, String> {
    Optional<AccountModel> findByEmail(String email);
    boolean existsByEmail(String email);
}
