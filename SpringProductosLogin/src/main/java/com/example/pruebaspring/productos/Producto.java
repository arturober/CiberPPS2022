package com.example.pruebaspring.productos;

import org.springframework.data.annotation.Id;

//Entidad que representa la tabla producto
public class Producto { 
    @Id
    private int id;
    private String nombre;
    private double precio;
    private int usuario;

    public Producto(int id, String nombre, double precio, int usuario) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.usuario = usuario;
    }

    public Producto() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
}
