package com.example.pruebaspring.productos;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductosService {
    private final ProductosRepository productosRepository;

    public ProductosService(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    public List<Producto> getAll() {
        return (List<Producto>)productosRepository.findAll();
    }

    public Producto getById(int id) {
        return productosRepository.findById(id).orElse(null);
    }

    public Producto insert(Producto producto) {
        producto.setId(0); // Al forzar la id a 0, se hará una insert auque nos llegue el producto con id
        return productosRepository.save(producto);
    }

    public Producto update(int id, Producto producto) {
        // Comprobar que existe el producto con la id y devolver un error 404 si no existe
        if(productosRepository.existsById(id)) {
            producto.setId(id);
            return productosRepository.save(producto);
        } else {
            return null; // Deberíamos devolver un error 404
        }
    }

    public void delete(int id) {
        productosRepository.deleteById(id);
    }
}
