package com.devs.tutorsapp.data.model;

public class ResenaDetalle {

    private int resena_id;
    private int alumno_id;
    private int tutor_id;
    private double puntuacion;
    private String comentario;
    private String fecha;
    private String alumnoNombre;
    private String alumnoApellido;

    public ResenaDetalle(int resena_id, int alumno_id, int tutor_id, double puntuacion, String comentario, String fecha, String alumnoNombre, String alumnoApellido) {
        this.resena_id = resena_id;
        this.alumno_id = alumno_id;
        this.tutor_id = tutor_id;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.fecha = fecha;
        this.alumnoNombre = alumnoNombre;
        this.alumnoApellido = alumnoApellido;
    }

    public int getResena_id() {
        return resena_id;
    }

    public void setResena_id(int resena_id) {
        this.resena_id = resena_id;
    }

    public int getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(int alumno_id) {
        this.alumno_id = alumno_id;
    }

    public int getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(int tutor_id) {
        this.tutor_id = tutor_id;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAlumnoNombre() {
        return alumnoNombre;
    }

    public void setAlumnoNombre(String alumnoNombre) {
        this.alumnoNombre = alumnoNombre;
    }

    public String getAlumnoApellido() {
        return alumnoApellido;
    }

    public void setAlumnoApellido(String alumnoApellido) {
        this.alumnoApellido = alumnoApellido;
    }
}
