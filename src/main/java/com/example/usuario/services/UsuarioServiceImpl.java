package com.example.usuario.services;

import com.example.usuario.exceptions.NotFoundException;
import com.example.usuario.repository.UsuarioRepositorio;
import com.example.usuario.request.UsuarioRequest;
import com.example.usuario.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

//@Service
public class UsuarioServiceImpl { // implements UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    //@Override
    public Usuario addUser(UsuarioRequest usuarioRequest) {

            Usuario user = Usuario.builder()
                    .id(usuarioRequest.getId())
                    .nombre(usuarioRequest.getNombre())
                    .apellido(usuarioRequest.getApellido())
                    .email(usuarioRequest.getEmail())
                    .password(usuarioRequest.getPassword())
                    .build();

        return usuarioRepositorio.save(user);

    }

    //@Override
    public List<Usuario> getAllUsers() {

        return (List<Usuario>) usuarioRepositorio.findAll();

    }

    //@Override
    public Usuario getUser(Long id) {

        return usuarioRepositorio.findById(id).orElseThrow(() -> new NotFoundException("User not exist with id " + id));

    }

    //@Override
    public List<Usuario> getUserByApellido(String nombre) {

        return usuarioRepositorio.findByApellido(nombre);

    }

    //@Override
    public Optional<Usuario> deleteUser(Long id) {

        Optional<Usuario> usr = usuarioRepositorio.findById(id);

        if (!usr.isEmpty()){
            usuarioRepositorio.deleteById(id);
        }

        return usr;
    }

}


