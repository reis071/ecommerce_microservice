package org.example.accounts.models.address;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.accounts.models.baseEntity.BaseEntity;
import org.example.accounts.models.user.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString
@Table(name = "address")
public class AddressModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    @NotNull
    private String cep;

    @Column
    @NotNull
    private String street;

    @Column
    @NotNull
    private String number;

    @Column
    @NotNull
    private String neighborhood;

    @Column
    @NotNull
    private String town;

    @Column
    @NotNull
    private String state;

    @OneToMany(mappedBy = "address")
    private List<UserModel> users = new ArrayList<>();

}
