package com.tiendaonline.tienda.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiendaonline.tienda.Service.UsuarioService;
import com.tiendaonline.tienda.Model.Usuario;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController
{

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    public List<Usuario>getAllUsuarios()
    {
        return usuarioService.getAllUsuarios();
    }


    @GetMapping("/{id}")
    public Optional<Usuario>getUsuarioById(@PathVariable int id_user)
    {
       return usuarioService.getUsuarioById(id_user);
    }

    
    //crear
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario)
    {
        return usuarioService.createUsuario(usuario);
    }


    //Actualizar
    @PutMapping("/{id}")
    public Usuario updUsuario(@PathVariable int id_user, @RequestBody Usuario usuario)
    {
        return usuarioService.updateUsuario(id_user, usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable int id_user)
    {
        usuarioService.deleteUsuario(id_user);
    }
    
}
