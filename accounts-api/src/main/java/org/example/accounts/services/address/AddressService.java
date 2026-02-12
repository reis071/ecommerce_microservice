package org.example.accounts.services.address;

import lombok.RequiredArgsConstructor;
import org.example.accounts.clients.ViaCepClient;
import org.example.accounts.dtos.address.AddressRequestDTO;
import org.example.accounts.dtos.address.AddressResponseDTO;
import org.example.accounts.dtos.viacep.ViaCepResponseDTO;
import org.example.accounts.mapppers.address.AddressMapper;
import org.example.accounts.models.address.AddressModel;
import org.example.accounts.repositories.address.AddressRepository;
import org.springframework.stereotype.Service;
import feign.FeignException;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final ViaCepClient viaCepClient;

    public AddressModel createAddress(AddressRequestDTO addressRequestDTO) {
        AddressModel addressModel = new AddressModel();

        String cepSemFormatacao = addressRequestDTO.cep().replaceAll("[^0-9]", "");

        if(addressRepository.findByCep(cepSemFormatacao).isPresent()) {

            addressModel.setNumber(addressRequestDTO.number());
            AddressModel savedAddress = addressRepository.save(addressModel);
            return savedAddress;

        }

        ViaCepResponseDTO viaCepResponse;
        try {
            viaCepResponse = viaCepClient.getAddressByCep(cepSemFormatacao);
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("CEP not found: " + addressRequestDTO.cep());
        } catch (FeignException e) {
            throw new RuntimeException("Failed to fetch CEP from BrasilAPI: " + e.status());
        }

        addressModel.setCep(addressRequestDTO.cep());

        addressModel.setStreet(
                addressRequestDTO.street() != null && !addressRequestDTO.street().isBlank()
                    ? addressRequestDTO.street() : viaCepResponse.street()
            );

        addressModel.setNeighborhood(
                addressRequestDTO.neighborhood() != null && !addressRequestDTO.neighborhood().isBlank()
                    ? addressRequestDTO.neighborhood() : viaCepResponse.neighborhood()
            );

        addressModel.setTown(
                addressRequestDTO.city() != null && !addressRequestDTO.city().isBlank()
                    ? addressRequestDTO.city() : viaCepResponse.city()
            );

        addressModel.setState(
                addressRequestDTO.state() != null && !addressRequestDTO.state().isBlank()
                    ? addressRequestDTO.state() : viaCepResponse.state()
            );

        addressModel.setNumber(addressRequestDTO.number());

        AddressModel savedAddress = addressRepository.save(addressModel);

        return savedAddress;


    }

    public ViaCepResponseDTO getAddressByCep(String cep) {
        String cepSemFormatacao = cep.replaceAll("[^0-9]", "");
        try {
            return viaCepClient.getAddressByCep(cepSemFormatacao);
        } catch (FeignException.NotFound e) {
            throw new RuntimeException("CEP not found: " + cep);
        } catch (FeignException e) {
            throw new RuntimeException("Failed to fetch CEP from BrasilAPI: " + e.status());
        }
    }
}
