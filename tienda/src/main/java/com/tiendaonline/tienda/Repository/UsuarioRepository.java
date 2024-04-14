package com.tiendaonline.tienda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendaonline.tienda.Model.SesionUsuario;
import com.tiendaonline.tienda.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>
{
   public SesionUsuario findByUserAndPassword(String usuario, String password);
}
