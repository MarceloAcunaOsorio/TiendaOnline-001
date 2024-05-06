package com.tiendaonline.tienda.controller;

import static org.mockito.Mockito.when;

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


import java.util.Arrays;
import java.util.List;


@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest 
{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioServiceImpl usuarioServiceMock;


    @Test
    public void obtenerTodosTest() throws Exception
    {
        //Arrange
        //Crear usuario

        //Usuario 1
        Usuario usuario1 = new Usuario();
        usuario1.setNombreuser("John");
        usuario1.setEmail("John123@gmail.com");
        usuario1.setDireccion("av. independencia #514");
        usuario1.setUsuario("jblack");
        usuario1.setPassword("123456");
        usuario1.setUserId(1);

        //Usuario 2
        Usuario usuario2 = new Usuario();
        usuario2.setNombreuser("Doe");
        usuario2.setEmail("Doe123@gmail.com");
        usuario2.setDireccion("av las torres #1125");
        usuario2.setUsuario("doelman");
        usuario2.setPassword("@1245jhgj");
        usuario2.setUserId(2);

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);
        when(usuarioServiceMock.getAllUsuarios()).thenReturn(usuarios);

        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(2)))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[0].nombreuser", Matchers.is("John")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[0].emailuser", Matchers.is("John123@gmail.com")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[0].direccion", Matchers.is("av. independencia #514")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[0].usuario", Matchers.is("jblack")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[0].password", Matchers.is("123456")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[1].Nombreuser", Matchers.is("Doe")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[1].emailuser", Matchers.is("Doe123@gmail.com")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[1].direccion", Matchers.is("av las torres #1125")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[1].usuario", Matchers.is("doelman")))
               .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.usuarioList[1].password", Matchers.is("@1245jhgj")));
    }
}
