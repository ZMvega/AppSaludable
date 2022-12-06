package com.example.appsaludable.Entidades;

public class Productos {
    private int id;
    private int imagen;
    private String nombre;
    private String descripción;
    private int precio;

    //Se generan los constructores - Segundo Paso
    public Productos(int id, int imagen, String nombre, String descripción, int precio) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripción = descripción;
        this.precio = precio;
    }

    //Se generaron primero los getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
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
