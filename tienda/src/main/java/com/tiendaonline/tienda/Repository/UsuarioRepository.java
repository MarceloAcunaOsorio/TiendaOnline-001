package com.tiendaonline.tienda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tiendaonline.tienda.Model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario,Integer>
{
  
}
