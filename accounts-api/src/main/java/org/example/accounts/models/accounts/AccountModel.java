package org.example.accounts.models.accounts;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.accounts.models.baseEntity.BaseEntity;
import org.example.accounts.models.user.UserModel;


@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "account")
public class AccountModel extends BaseEntity {

    @Id
    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String password;

    @OneToOne
    private UserModel user;

}
