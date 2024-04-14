package com.tiendaonline.tienda.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "SesionUsuario")
public class SesionUsuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsesion")
    private int id_sesion;

    @Column(name ="usuario")
    private String usuario;


    @Column(name = "Password")
    private String password;



    //getter

    public int getId_sesion()
    {
        return id_sesion;
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
    public void setId_sesion( int id_sesion)
    {
        this.id_sesion = id_sesion;
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
