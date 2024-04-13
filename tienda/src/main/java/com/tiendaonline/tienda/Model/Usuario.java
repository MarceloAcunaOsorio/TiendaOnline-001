package com.tiendaonline.tienda.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id_user;

    @Column(name = "nombre")
    private String nombre_user;

    @Column(name = "password")
    private String password_user;

    @Column(name = "email")
    private String email_user;

    @Column(name = "direccion")
    private Direccion direccion;

    @Column(name = "rol")
    private TipoUsuario tipousuario;


    //setter
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

    public Direccion getDireccion()
    {
        return direccion;
    }

    public TipoUsuario getTipousuario()
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

    public void setDireccion(Direccion direccion)
    {
        this.direccion = direccion;
    }

    public void getTipousuario(TipoUsuario tipousuario)
    {
       this.tipousuario = tipousuario;
    }

}
