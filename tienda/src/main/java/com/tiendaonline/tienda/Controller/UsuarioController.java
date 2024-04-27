package com.tiendaonline.tienda.Controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;

import com.tiendaonline.tienda.Service.UsuarioService;
import com.tiendaonline.tienda.Model.Usuario;






@RestController
@RequestMapping("/usuarios")
public class UsuarioController
{

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);    

    @Autowired
    private UsuarioService usuarioService;


    /*
    //mostrar listado de todos los usuarios
    @GetMapping
    public List<Usuario>getAllUsuarios()
    {   log.info("GET /usuarios");
        log.info("Retornando Todos los usuarios");  
        return usuarioService.getAllUsuarios();
    }
    */

        @GetMapping
     public CollectionModel<EntityModel<Usuario>> getAllUsuarios()
     {
        log.info("GET /usuarios");
        log.info("Retornando todos los usuarios");
        List<Usuario> usuarios = usuarioService.getAllUsuarios();

        List<EntityModel<Usuario>> usuarioResources = usuarios.stream()
            .map(usuario -> EntityModel.of(usuario,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getUsuarioById(usuario.getUserId())).withSelfRel()
                    ))
            .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsuarios());
        CollectionModel<EntityModel<Usuario>> resources = CollectionModel.of(usuarioResources, linkTo.withRel("usuarios")); 

        return resources;
     }





    //buscar usuario
    @GetMapping("/{userId}")
    public ResponseEntity<Object>getUsuarioById(@PathVariable int userId)
    {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(userId);
        if(usuario.isEmpty())
        {
           log.error("No se encuentro el Usuario con ID {}", userId);
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("No se encontro el usuario con ID " + userId));
        }
        return ResponseEntity.ok(usuario);
    }




    //crear
    @PostMapping
    public ResponseEntity<Object> createUsuario(@Validated @RequestBody Usuario usuario)
    {
      Usuario createdUsuario = usuarioService.createUsuario(usuario);
      if(createdUsuario == null)
      {
        log.error("Error al crear el Usuario {userId}",usuario);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Error al crear el Usuario"));
      }
      return ResponseEntity.ok(createdUsuario);
    }





    //Actualizar
    @PutMapping("/{userId}")
    public Usuario updUsuario(@PathVariable int userId, @RequestBody Usuario usuario)
    {
        return usuarioService.updateUsuario(userId, usuario);
    }





    @DeleteMapping("/{userId}")
    public void deleteUsuario(@PathVariable int userId)
    {
        usuarioService.deleteUsuario(userId);
    }
    
    static class ErrorResponse
    {
        private final String message;

        public ErrorResponse(String message)
        {
            this.message = message;
        }

        public String getMessage()
        {
            return message;
        }
    }

  

     
}
