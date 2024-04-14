package com.tiendaonline.tienda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tiendaonline.tienda.Model.Usuario;
import com.tiendaonline.tienda.Repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    
    @Override
    public List<Usuario>getAllUsuarios()
    {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario>getUsuarioById(int userId)
    {
        return usuarioRepository.findById(userId);
    }


     //crear
    @Override
    public Usuario createUsuario(Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }


    //actualizar

    public Usuario updateUsuario (int userId,Usuario usuario)
    {
        if(usuarioRepository.existsById(userId))
        {
            usuario.setUserId(userId);
            return usuarioRepository.save(usuario);
        }
        else
        {
            return null;
        }
    }


    //borrar usuario
    @Override
    public void deleteUsuario(int userId)
    {
        usuarioRepository.deleteById(userId);
    }



}
