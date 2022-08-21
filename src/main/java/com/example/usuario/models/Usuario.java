package com.example.usuario.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuario")
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Data
public class Usuario {

    @Id
    @Column(name="id_usuario", unique = true, nullable = false)
    @GeneratedValue(generator = "SEC_USUARIO", strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEC_USUARIO", sequenceName = "SEC_USUARIO",allocationSize=1)
    private Long id;

    @Column(name="nombre")
    @NotNull
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="email")
    private String email;

    @Column(name="password")
    @NotNull
    private String password;

}
