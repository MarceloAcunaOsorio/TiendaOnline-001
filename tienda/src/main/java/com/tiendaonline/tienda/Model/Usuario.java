package com.tiendaonline.tienda.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "Usuario")
public class Usuario 
{
    @Valid

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_user;
    

    //@NotBlank(message = "name is mandatory")
    //@NotNull(message = "name is mandatory")
    @Column(name = "nombre")
    private String nombre_user;

    @Email
    @Column(name = "email")
    private String email_user;

    @Column(name = "direccion")
    private String direccion;

    @Column(name ="usuario")
    private String usuario;


    @Column(name = "Password")
    private String password;

    //getter
    public int getId_user()
    {
        return id_user;
    }

    public String getNombre_User()
    {
        return nombre_user;
    }


    public String getEmail()
    {
        return email_user;
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
    public void setId(int id_user)
    {
        this.id_user = id_user;
    }

    public void setNombreuser(String nombre_user)
    {
        this.nombre_user = nombre_user;
    }

    public void setEmail(String email_user)
    {
       this.email_user = email_user;
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
