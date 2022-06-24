package com.acme.apirest.models.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.apirest.models.entity.Proveedor;

public interface IProveedorDAO extends JpaRepository<Proveedor, UUID> {
    // cON ESTO TENEMOS LOS MÉTODOS "HABITUALES" de CRUD y se podrán especificar otros  "a MEDIDA"
    public List<Proveedor> findByNombreStartsWith(String term);
    
}
