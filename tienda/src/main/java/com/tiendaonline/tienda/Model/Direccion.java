package com.tiendaonline.tienda.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Direccion")
public class Direccion 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private int id_Direccion;


    @Column(name = "NombreDireccion")
    private String nombreDireccion;


    //getter
    public int getId()
    {
        return id_Direccion;
    }

    public String getNombreDireccion()
    {
        return nombreDireccion;
    }


    //setter
    public void setIdDireccion(int id_Direccion )
    {
        this.id_Direccion = id_Direccion;
    }

    public void setNombreDireccion(String nombreDireccion)
    {
        this.nombreDireccion = nombreDireccion;
    }
    
}
