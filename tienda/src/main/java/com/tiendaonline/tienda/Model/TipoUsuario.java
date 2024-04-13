package com.tiendaonline.tienda.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TipoUsuario")
public class TipoUsuario 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;

    @Column(name ="NombreRol")
    private String nombrerol;


    //getter
    public int getId()
    {
        return id_rol;
    }

    public String getNombreRol()
    {
        return nombrerol;
    }


    //setter
    public void setId( int id_rol)
    {
        this.id_rol = id_rol;
    }

    public void setNomreRol(String nombrerol)
    { 
        this.nombrerol = nombrerol;
    }

}
