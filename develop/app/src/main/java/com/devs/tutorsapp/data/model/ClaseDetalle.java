package com.devs.tutorsapp.data.model;

public class ClaseDetalle {

    private int clase_id;
    private String fecha;
    private String hora_inicio;
    private String estado;
    public String tutorNombre;
    public String tutorApellido;
    public String materiaNombre;

    public ClaseDetalle(int clase_id, String fecha, String hora_inicio, String estado, String tutorNombre, String tutorApellido, String materiaNombre) {
        this.clase_id = clase_id;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.estado = estado;
        this.tutorNombre = tutorNombre;
        this.tutorApellido = tutorApellido;
        this.materiaNombre = materiaNombre;
    }

    public int getClase_id() {
        return clase_id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public String getEstado() {
        return estado;
    }

    public String getTutorNombre() {
        return tutorNombre;
    }

    public String getTutorApellido() {
        return tutorApellido;
    }

    public String getMateriaNombre() {
        return materiaNombre;
    }
}
