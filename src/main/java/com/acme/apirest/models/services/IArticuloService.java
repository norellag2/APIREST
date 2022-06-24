package com.acme.apirest.models.services;

import java.util.List;
import java.util.UUID;

import com.acme.apirest.models.entity.Articulo;

//En esta interfaz vamos a definir los métodos que usaremos en la operaciones de nuestra tabla articulos


public interface IArticuloService {
     //Método para retornar todos los artículos
     public List<Articulo> findAll();
     //Método para retornar los artículos por su campo "modelo"
     public  List<Articulo> searchArticulosByModelo(String term);
     
     //Método para retornar un artículo por su id
     public Articulo findById(UUID id);
     
     
     //Método para crear nuevos artículos o actualizarlos
     public Articulo save(Articulo articulo);

     // Método para eliminar un artículo
     public void delete(UUID id); 


}
