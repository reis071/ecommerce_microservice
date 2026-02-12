package org.example.accounts.repositories.address;

import org.example.accounts.dtos.address.AddressRequestDTO;
import org.example.accounts.models.address.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, UUID> {

    Optional<AddressModel> findByCep(String cep);
}

