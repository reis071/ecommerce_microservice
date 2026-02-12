package org.example.accounts.controllers.address;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.accounts.dtos.address.AddressRequestDTO;
import org.example.accounts.dtos.address.AddressResponseDTO;
import org.example.accounts.dtos.viacep.ViaCepResponseDTO;
import org.example.accounts.mapppers.address.AddressMapper;
import org.example.accounts.services.address.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @GetMapping("/cep/{cep}")
    public ResponseEntity<ViaCepResponseDTO> getAddressByCep(@PathVariable String cep) {
        return ResponseEntity.ok(addressService.getAddressByCep(cep));
    }

    @PutMapping public ResponseEntity<AddressResponseDTO> createAddress(@Valid @RequestBody AddressRequestDTO addressRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body( addressMapper.toResponseDTO( addressService.createAddress(addressRequestDTO) )) ;
    }

}
