package com.tiendaonline.tienda.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import org.slf4j.Logger;






@RestController
@RequestMapping("/usuarios")
public class UsuarioController
{

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);    

    @Autowired
    private UsuarioService usuarioService;


    //mostrar listado de todos los usuarios
    @GetMapping
    public List<Usuario>getAllUsuarios()
    {   log.info("GET /usuarios");
        log.info("Retornando Todos los usuarios");  
        return usuarioService.getAllUsuarios();
    }



    //buscar usuario
    @GetMapping("/{id}")
    public ResponseEntity<Object>getUsuarioById(@PathVariable int id_user)
    {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id_user);
        if(usuario.isEmpty())
        {
           log.error("No se encuentro el Usuario con ID {}",id_user);
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("No se encontro el usuario con ID" + id_user));
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
        log.error("Error al crear el Usuario {}",usuario);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Error al crear el Usuario"));
      }
      return ResponseEntity.ok(createdUsuario);
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
