package com.acme.apirest.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.acme.apirest.models.entity.Proveedor;

public interface IProveedorService {
    // esta interfaz define los métodos que tendrá que implementar nuestro servicio de proveedores
    public List<Proveedor> findAll();

    // Método get con paginación
    public Page<Proveedor> findAll(Pageable pageable); 
    //Método save para crear o actualizar un proveedor
    public Proveedor save(Proveedor proveedor);
    //Método para buscar proveedor por nombre
    public List<Proveedor> findByNombreStartsWith(String term);
}
