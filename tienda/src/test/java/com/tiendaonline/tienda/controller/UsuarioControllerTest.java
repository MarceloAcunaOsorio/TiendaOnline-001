package com.tiendaonline.tienda.controller;

import static org.mockito.Mockito.when;


import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.tiendaonline.tienda.Controller.UsuarioController;
import com.tiendaonline.tienda.Model.Usuario;
import com.tiendaonline.tienda.Service.UsuarioServiceImpl;


import java.util.List;
import java.util.Arrays;


@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest 
{
   @Autowired
   private MockMvc mockMvc;


   @MockBean
   private UsuarioServiceImpl usuarioServicioMock;



   @Test
   public void obtenerTodosTest() throws Exception
   {
     //Arrange
     //creacion usuario
      
     //usuario 1
     Usuario usuario1 = new Usuario();
     usuario1.setNombreuser("John");
     usuario1.setUserId(1);



     //usuario 2
     Usuario usuario2 = new Usuario();
     usuario2.setNombreuser("Doe");
     usuario2.setUserId(2);
   
   
     List<Usuario> usuario = Arrays.asList(usuario1,usuario2);
     when(usuarioServicioMock.getAllUsuarios()).thenReturn(usuario);


     mockMvc.perform(MockMvcRequestBuilders.get("/usuarios"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.aMapWithSize(2)))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[0].nombreuser", Matchers.is("John")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[1].nombreuser", Matchers.is("Doe")));
   
    }
}
