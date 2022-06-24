package com.acme.apirest.models.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.apirest.models.dao.IOfertaDAO;
import com.acme.apirest.models.entity.Oferta;

@Service
public class OfertaService implements IOfertasService {
    @Autowired
    private IOfertaDAO ofertaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Oferta> findByArticuloId(String articuloId) {
        return ofertaDao.searchOfertaByArticulo(articuloId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Oferta> findByProveedorId(String proveedorId) {
        return ofertaDao.searchOfertaByProveedor(proveedorId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Oferta> findByArticuloIdAndProveedorId(String articuloId, String proveedorId) {
        return ofertaDao.searchOfertaByArticuloAndProveedor(articuloId, proveedorId);
    }

    @Override
    @Transactional()
    public Oferta save(Oferta oferta) {
       
        return ofertaDao.save(oferta);
    }
    
}
