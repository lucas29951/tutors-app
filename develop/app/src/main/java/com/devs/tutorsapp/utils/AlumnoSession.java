package com.devs.tutorsapp.utils;

public class AlumnoSession {

    private final int id;
    private final String nombre;
    private final String email;

    public AlumnoSession(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
