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
    public Optional<Usuario>getUsuarioById(int id_user)
    {
        return usuarioRepository.findById(id_user);
    }


     //crear
    @Override
    public Usuario createUsuario(Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }


    //actualizar

    public Usuario updateUsuario (int id_user,Usuario usuario)
    {
        if(usuarioRepository.existsById(id_user))
        {
            usuario.setId(id_user);
            return usuarioRepository.save(usuario);
        }
        else
        {
            return null;
        }
    }


    //borrar usuario
    @Override
    public void deleteUsuario(int id_user)
    {
        usuarioRepository.deleteById(id_user);
    }
}
