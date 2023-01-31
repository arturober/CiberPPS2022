package com.example.pruebaspring.productos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductosRepository extends CrudRepository<Producto, Integer> {
    // @Query("SELECT * from producto WHERE precio < :precio")
    // List<Producto> findCheaper(double precio);

    List<Producto> findByPrecioLessThan(double precio);
}
