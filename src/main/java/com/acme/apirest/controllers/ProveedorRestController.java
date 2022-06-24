package com.acme.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.apirest.models.entity.Proveedor;
import com.acme.apirest.models.services.IProveedorService;

@CrossOrigin(origins={"http://localhost:4200"} ) // permitir peticiones y desbloquear el CROS del navegador
@RestController
@RequestMapping("/api")

public class ProveedorRestController {
    
    @Autowired
    private IProveedorService proveedorService;

    @GetMapping("/proveedores")
    public List<Proveedor> index() {
        return proveedorService.findAll();
    }

    @GetMapping("/proveedores/page/{pageNumber}")
    public Page<Proveedor> index(@PathVariable int pageNumber) {
         return proveedorService.findAll(PageRequest.of(pageNumber, 5, Sort.by("localidad", "nombre")));
    }

    @GetMapping("/proveedores/search/{term}")
    public List<Proveedor> search(@PathVariable String term) {
      return proveedorService.findByNombreStartsWith(term);
    }

    @PostMapping("/proveedores")
    public ResponseEntity<?> create(@RequestBody Proveedor proveedor) {
       Proveedor newProveedor = null;
       Map<String, Object> response = new HashMap<>();
       try {
          newProveedor = proveedorService.save(proveedor);
       } catch(DataAccessException e) { 
          if(e.getMostSpecificCause().getMessage().contains("Duplicate entry")) {
            response.put("message", "CIF duplicado");
            return new ResponseEntity<Map<String, Object>> (response, HttpStatus.BAD_REQUEST);
          } else {
            response.put("message", "Servidor no disponible");
            return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
          }
       }
       response.put("message", "El proveedor fue creado correctamente");
       return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
    }
}
