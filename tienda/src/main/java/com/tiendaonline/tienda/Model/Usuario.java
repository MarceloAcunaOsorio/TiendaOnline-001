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
    private String nombreuser;

    @Email
    @Column(name = "email")
    private String emailuser;

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

    public String getNombreUser()
    {
        return nombreuser;
    }


    public String getEmail()
    {
        return emailuser;
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

    public void setNombreuser(String nombreuser)
    {
        this.nombreuser = nombreuser;
    }

    public void setEmail(String emailuser)
    {
       this.emailuser = emailuser;
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
