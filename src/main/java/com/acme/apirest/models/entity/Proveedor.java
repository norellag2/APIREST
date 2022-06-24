package com.acme.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable {
    
    @Id // Marco el atributo como clave primaria de la table
    @GeneratedValue // se generará automaticamente su valor
    @Type(type= "org.hibernate.type.UUIDCharType")
    private UUID id;
    @Column(nullable = false) // es obligatorio el campo
    private String nombre;
    @Column(nullable = false, unique = true, length = 9)
    private String cif;
    private String direccion; // si no hay validaciones (continúa siguiente línea)
    private String localidad; // no es necesario anotar los atributos
    @Column(nullable = false)
    private String email;
    private String telefono;
    @Column(nullable = false, name = "fecha_alta") // usamos name para cambiar en base de datos
    private Date fechaAlta = new Date();

    //Creamos una propiedad para las ofertas asociadas a este proveedor
    @JsonIgnoreProperties(value = { "proveedor",
                                    "hibernateLazyInitializer",
                                    "handler" }, 
                                    allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY,
               mappedBy = "proveedor", 
               cascade = CascadeType.ALL)
    private List<Oferta> ofertas;

    public Proveedor() {
          this.ofertas = new ArrayList<>();
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return this.cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaAlta() {
        return this.fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


    private static final long serialVersionUID = 1L;
}
