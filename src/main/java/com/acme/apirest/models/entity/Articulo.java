package com.acme.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="articulos")
public class Articulo implements Serializable {
   
    @Id //Clave única de la tabla
    @GeneratedValue // el valor lo genere automaticamente
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;
    @Column(length = 4, unique = true, nullable = false)
    private String sku;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modelo;
    //si no tiene ninguna constraint no hace falta usar @Column
    private String descripcion;
    @Enumerated(value= EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;
    @Column(name = "fecha_alta")
    private Date fechaAlta = new Date();
     //Creamos una propiedad para las ofertas asociadas a este articulo
    @JsonIgnoreProperties(value = {"articulo",
                                    "hibernateLazyInitializer",
                                    "handler"},
                          allowSetters = true)
    @OneToMany(fetch =  FetchType.LAZY,
               mappedBy = "articulo",
               cascade = CascadeType.ALL)
    private List<Oferta> ofertas;
    
    public Articulo() {
       this.ofertas = new ArrayList<>();
    }


    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }



    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }



    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }



    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }



    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }



    public Date getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

private static final long serialVersionUID = 1L;

}
