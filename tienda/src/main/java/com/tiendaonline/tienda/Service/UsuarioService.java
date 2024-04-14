package com.tiendaonline.tienda.Service;

import java.util.Optional;

import com.tiendaonline.tienda.Model.SesionUsuario;
import com.tiendaonline.tienda.Model.Usuario;
import java.util.List;

public interface UsuarioService
{
    //obtiene un listado de la clase usuario
    List<Usuario>getAllUsuarios();


    //obtiene el id de los datos que estan en la clase Usuario
    Optional<Usuario>getUsuarioById(int id_user);


    //crear
    Usuario createUsuario(Usuario usuario);


    //actualizar
    Usuario updateUsuario(int id_user,Usuario usuario);


    //eliminar
    void deleteUsuario(int id_user);

   

}
