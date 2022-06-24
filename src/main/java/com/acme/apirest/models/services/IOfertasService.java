package com.acme.apirest.models.services;

import java.util.List;

import com.acme.apirest.models.entity.Oferta;

public interface IOfertasService {

    public List<Oferta> findByArticuloId(String articuloId);
    public List<Oferta> findByProveedorId(String proveedorId);
    public List<Oferta> findByArticuloIdAndProveedorId(String articuloId, String proveedorId);

    public Oferta save(Oferta oferta);
}
