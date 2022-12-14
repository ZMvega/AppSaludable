package com.example.appsaludable.Entidades;

import java.util.UUID;

public class Productos {
    private String id;
    private String imagen;
    private String nombre;
    private String descripción;
    private int precio;

    //Se generan los constructores - Segundo Paso
    public Productos(String nombre, String descripción, int precio, String imagen) {
        this.id = UUID.randomUUID().toString();
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripción = descripción;
        this.precio = precio;
    }

    public Productos(String id, String nombre, String descripción, int precio, String imagen) {
        this.id = UUID.randomUUID().toString();
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripción = descripción;
        this.precio = precio;
    }

    public Productos(String id, String nombre, String descripción, int precio) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.descripción = descripción;
        this.precio = precio;
    }

    public Productos(String nombre, String descripción, int precio) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.descripción = descripción;
        this.precio = precio;
    }

    //Se generaron primero los getters and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
