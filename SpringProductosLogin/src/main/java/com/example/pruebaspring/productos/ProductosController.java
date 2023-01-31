package com.example.pruebaspring.productos;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductosController {
    private final ProductosService productosService; 

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping
    public List<Producto> getAll(@RequestParam(required = false, defaultValue = "0") double cheaper) {
        if(cheaper > 0) {
            return productosService.findCheaper(cheaper);
        } else {
            return productosService.getAll();
        }
    }

    @GetMapping("/{id}")
    public Producto getById(@PathVariable int id) {
        return productosService.getById(id);
    }

    @PostMapping
    public Producto insert(@RequestBody Producto producto) {
        return productosService.insert(producto);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable int id, @RequestBody Producto producto) {
        return productosService.update(id, producto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productosService.delete(id);
    }
}
