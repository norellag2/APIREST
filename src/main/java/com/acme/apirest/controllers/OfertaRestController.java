package com.acme.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acme.apirest.models.entity.Oferta;
import com.acme.apirest.models.services.IOfertasService;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/api")

public class OfertaRestController {
    @Autowired
    private IOfertasService ofertaService;

    @GetMapping("/ofertas/articulo/{articuloId}")
    public List<Oferta> showByArticulo(@PathVariable String articuloId) {
        return ofertaService.findByArticuloId(articuloId);
    }

    @GetMapping("/ofertas/proveedor/{proveedorId}")
    public List<Oferta> showByProveedor(@PathVariable String proveedorId) {
        return ofertaService.findByProveedorId(proveedorId);
    }

    @GetMapping("/ofertas/articulo-proveedor/{articuloId}/{proveedorId}")
    public List<Oferta> showByArticuloAndProveedor(@PathVariable String articuloId, @PathVariable String proveedorId){
        return ofertaService.findByArticuloIdAndProveedorId(articuloId, proveedorId);
    }

    @PostMapping("/ofertas")
    @ResponseStatus(HttpStatus.CREATED)
    public Oferta create(@RequestBody Oferta oferta) {
        return ofertaService.save(oferta);

    }
}
