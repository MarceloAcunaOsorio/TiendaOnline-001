package com.tiendaonline.tienda.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;


@Entity
@Table(name = "Usuario")
public class Usuario extends RepresentationModel<Usuario>
{
    @Valid

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;
    

    //@NotBlank(message = "name is mandatory")
    //@NotNull(message = "name is mandatory")
    @Column(name = "nombre")
    private String nombre;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "direccion")
    private String direccion;

    @Column(name ="usuario")
    private String usuario;

    @Column(name = "Password")
    private String password;

    //getter
    public int getUserId()
    {
        return userId;
    }

    public String getNombre()
    {
        return nombre;
    }


    public String getEmail()
    {
        return email;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public String getPassword()
    {
        return password;
    }


    //setter
    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setEmail(String email)
    {
       this.email = email;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public void setUsuario(String usuario)
    {
       this.usuario = usuario;
    }

    public void setPassword(String password)
    {
      this.password = password;
    }

}
