package com.tiendaonline.tienda.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tiendaonline.tienda.Model.Usuario;
import com.tiendaonline.tienda.Repository.UsuarioRepository;
import com.tiendaonline.tienda.Service.UsuarioServiceImpl;



@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest 
{
   @InjectMocks
   private UsuarioServiceImpl usuarioServicio;




   @Mock
   public UsuarioRepository usuarioRepositorioMock;




   @Test
   public void guardarUsuarioTest()
   {
     //Arrange
     Usuario usuario = new Usuario();
     usuario.setNombre("Jose Randon");

     when(usuarioRepositorioMock.save(any())).thenReturn(usuario);

     //Act
     Usuario resultado = usuarioServicio.createUsuario(usuario);


     //Assert
     assertEquals("Jose Randon", resultado.getNombre());

   }
}
