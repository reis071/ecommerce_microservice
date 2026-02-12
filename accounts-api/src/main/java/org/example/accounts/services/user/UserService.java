package org.example.accounts.services.user;

import lombok.RequiredArgsConstructor;
import org.example.accounts.dtos.user.UserRequestDTO;
import org.example.accounts.dtos.user.UserResponseDTO;
import org.example.accounts.mapppers.user.UserMapper;
import org.example.accounts.models.user.UserModel;
import org.example.accounts.repositories.user.UserRepository;
import org.example.accounts.services.address.AddressService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressService addressService;

    public UserResponseDTO getUserByCpf(String cpf) {
        Optional<UserModel> userModel = userRepository.findByCpf(cpf);

        if (userModel.isEmpty()) {
            throw new RuntimeException("User not found with CPF: " + cpf);
        }
        return userMapper.toResponseDTO(userModel.get());
    }

    public UserModel createUser(UserRequestDTO userRequestDTO) {

        UserModel userModel = userMapper.toEntity(userRequestDTO);


        userModel.setAddress(addressService.createAddress(userRequestDTO.address()));


        UserModel savedUser = userRepository.save(userModel);
        return savedUser;
    }

    public UserResponseDTO updateUser(UUID id, UserRequestDTO userRequestDTO) {
        UserModel existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(userRequestDTO.name());
        existingUser.setLastName(userRequestDTO.lastName());
        existingUser.setCpf(userRequestDTO.cpf());
        existingUser.setBirthDate(userRequestDTO.birthDate());
        // do not change password here; provide dedicated endpoint if needed

        if (userRequestDTO.address() != null) {
            addressService.createAddress(userRequestDTO.address());
        }

        UserModel updatedUser = userRepository.save(existingUser);
        return userMapper.toResponseDTO(updatedUser);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
