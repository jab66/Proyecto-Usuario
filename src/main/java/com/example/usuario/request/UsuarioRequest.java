package com.example.usuario.request;

import lombok.*;

@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Data
public class UsuarioRequest {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

}
