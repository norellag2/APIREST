package com.acme.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.apirest.models.entity.Articulo;
import com.acme.apirest.models.services.IArticuloService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")// Ruta del endpoint de la API

public class ArticuloRestController {
    @Autowired
    private IArticuloService articuloService;

    @GetMapping("/articulos")
    public ResponseEntity<?> read() {
      List<Articulo> articulos = articuloService.findAll();
      Map<String, Object> response = new HashMap<>();
      response.put("message", "ok");
      response.put("articulos", articulos);
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/articulos/search/modelo/{term}")
    public ResponseEntity<?> searchByModelo(@PathVariable String term) {
      List<Articulo> articulos = articuloService.searchArticulosByModelo(term);
      Map<String, Object> response = new HashMap<>();
      response.put("message", "ok");
      response.put("articulos", articulos);
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping ("/articulos/{id}")
    public ResponseEntity<?> searchById(@PathVariable UUID id) {
      Articulo articulo = articuloService.findById(id);
      Map<String, Object> response = new HashMap<>();
      response.put("message", "ok");
      response.put("articulo", articulo);
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


    @PostMapping("/articulos")
    public ResponseEntity<?> create(@RequestBody Articulo articulo) {
      Articulo newArticulo = null;
      Map<String, Object> response = new HashMap<>();
      try {
          newArticulo = articuloService.save(articulo);
      } catch (DataAccessException e) {
          if (e.getMostSpecificCause().getMessage().contains("Duplicate entry")) {
              response.put("message", "Código SKU duplicado");
              return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
          } else {
             response.put("message", "El servidor no se encuentra disponible");
             return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
          }
      }
      response.put("message", "El artículo fue creado correctamente");
      response.put("article", newArticulo);
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @PutMapping("/articulos/{id}")
    public Articulo update(@RequestBody Articulo articulo, @PathVariable UUID id) {
      // En primer lugar llamamos a la base de datos para obtener el artículo
      Articulo articuloPrev = articuloService.findById(id);
      articuloPrev.setSku(articulo.getSku());
      articuloPrev.setMarca(articulo.getMarca());
      articuloPrev.setModelo(articulo.getModelo());
      articuloPrev.setGenero(articulo.getGenero());
      articuloPrev.setDescripcion(articulo.getDescripcion());
      return articuloService.save(articuloPrev);

    }
    @DeleteMapping("/articulos/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
      Map<String, Object> response = new HashMap<>();
      try {
        articuloService.delete(id);
      } catch (DataAccessException e) {
             response.put("message", "El servidor no se encuentra disponible");
             return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
           }

      response.put("message", "El artículo fue eliminado correctamente");
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
