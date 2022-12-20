package com.example.pruebaspring.productos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProductosRepository extends CrudRepository<Producto, Integer> {
    
}
