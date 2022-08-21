package com.example.usuario.models;

import com.example.usuario.validators.ContentWithoutSpaces;
import com.example.usuario.validators.NotStartWithNumber;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="usuarios",
        uniqueConstraints = {
            @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        })
@ToString
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty(message = "{username.not.empty}")
    @Size(min=5, message = "{username.min.character}")
    @NotStartWithNumber
    @ContentWithoutSpaces
    @Column(name="username")
    private String username;

    @Email
    @NotNull
    @NotBlank
    @Column(name="email")
    private String email;

    @NotNull
    @NotBlank
    @ContentWithoutSpaces
    @Column(name="password")
    private String password;


}
