package com.example.pruebaspring.productos;

import org.springframework.stereotype.Service;

@Service
public class ProductosService {
    private final ProductosRepository productosRepository;

    public ProductosService(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    public Iterable<Producto> getAll() {
        return productosRepository.findAll();
    }
}
