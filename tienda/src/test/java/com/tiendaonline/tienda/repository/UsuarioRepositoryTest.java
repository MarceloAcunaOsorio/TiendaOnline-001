package com.tiendaonline.tienda.repository;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tiendaonline.tienda.Model.Usuario;
import com.tiendaonline.tienda.Repository.UsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioRepositoryTest 
{
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Test
    public void guardarUsuarioTest()
    {
        //Arrange
        Usuario usuario = new Usuario();
        usuario.setNombreuser("John Doe");


        //Act
        Usuario resultado = usuarioRepository.save(usuario);

        //Assert
        assertNotNull(resultado.getUserId());
        assertEquals("John Doe",resultado.getNombre_User());
    }  
}
