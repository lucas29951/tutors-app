package com.devs.tutorsapp.data.model;

public class Tutor {

    private String nombre;
    private String apellido;
    private String precio;
    private String descripcion;

    public Tutor(String nombre, String apellido, String precio, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
