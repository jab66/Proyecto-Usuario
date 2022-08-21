package com.example.usuario.services;

import com.example.usuario.request.UsuarioRequest;
import com.example.usuario.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public Usuario addUser(UsuarioRequest usuarioRequest);

    public List<Usuario> getAllUsers();

    public Usuario getUser(Long id);

    public List<Usuario> getUserByApellido(String nombre);

    public Optional<Usuario> deleteUser(Long id);
}
