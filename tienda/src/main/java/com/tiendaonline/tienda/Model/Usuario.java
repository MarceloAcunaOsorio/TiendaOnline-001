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
    

    @NotBlank(message = "name is mandatory")
    @NotNull(message = "name is mandatory")
    @Column(name = "nombre")
    private String nombre_user;

   
    @Column(name = "password")
    private String password_user;

    @Email
    @Column(name = "email")
    private String email_user;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "rol")
    private int tipousuario;


    //getter
    public int getId_user()
    {
        return id_user;
    }

    public String getNombre_User()
    {
        return nombre_user;
    }

    public String getPassword()
    {
        return password_user;
    }

    public String getEmail()
    {
        return email_user;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public int getTipousuario()
    {
        return tipousuario;
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

    public void serPassworduser(String password_user)
    {
        this.password_user = password_user;
    }

    public void setEmail(String email_user)
    {
       this.email_user = email_user;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public void getTipousuario(int tipousuario)
    {
       this.tipousuario = tipousuario;
    }

}
