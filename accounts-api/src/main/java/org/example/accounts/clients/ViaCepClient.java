package org.example.accounts.clients;

import org.example.accounts.dtos.viacep.ViaCepResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "brasilApi", url = "https://brasilapi.com.br/api/cep/v1/")
public interface ViaCepClient {

    @GetMapping("{cep}")
    ViaCepResponseDTO getAddressByCep(@PathVariable("cep") String cep);
}
