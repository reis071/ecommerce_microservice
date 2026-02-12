package org.example.accounts.models.user;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import org.example.accounts.models.address.AddressModel;
import org.example.accounts.models.baseEntity.BaseEntity;

import java.time.LocalDateTime;

import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "users")
public class UserModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String lastName;

    @Column
    @NotNull
    private String cpf;

    @Column
    @NotNull
    private LocalDateTime birthDate;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressModel address;
}
