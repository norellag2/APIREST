package com.acme.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import java.util.UUID;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ofertas")

public class Oferta implements Serializable {
    @Id
    @GeneratedValue
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    // Establecemos articulo como clave foránea de la tabla articulos con la siguiente sintaxis de anotaciones en Spring
    @JsonIgnoreProperties(value = {"ofertas", 
                                   "hibernateLazyInitializer",  
                                   "handler"}, 
                          allowSetters = true)
    @JoinColumn(name = "articulo_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Articulo articulo;
    //idem anterior
    @JsonIgnoreProperties(value = {"ofertas", 
                                   "hibernateLazyInitializer",  
                                   "handler"}, 
                         allowSetters = true)
    @JoinColumn(name = "proveedor_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Proveedor proveedor;
    @Column(nullable = false)
    private double precio;
    @Column(nullable = false, name = "plazo_entrega_dias")
    private int plazoEntregaDias;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion = new Date();

   
    
    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Articulo getArticulo() {
        return this.articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Proveedor getProveedor() {
        return this.proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPlazoEntregaDias() {
        return this.plazoEntregaDias;
    }

    public void setPlazoEntregaDias(int plazoEntregaDias) {
        this.plazoEntregaDias = plazoEntregaDias;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



    private static final long serialVersionUID = 1L;
}
