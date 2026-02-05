package com.devs.tutorsapp.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "resenas",
        foreignKeys = {
                @ForeignKey(
                        entity = AlumnoEntity.class,
                        parentColumns = "alumno_id",
                        childColumns = "alumno_id",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = TutorEntity.class,
                        parentColumns = "tutor_id",
                        childColumns = "tutor_id",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index("alumno_id"),
                @Index("tutor_id")
        }
)
public class ResenaEntity {

    @PrimaryKey(autoGenerate = true)
    private int resena_id;

    private int alumno_id;
    private int tutor_id;

    private double puntuacion;
    private String comentario;
    private String fecha;

    public ResenaEntity(int alumno_id, int tutor_id, double puntuacion, String comentario, String fecha) {
        this.alumno_id = alumno_id;
        this.tutor_id = tutor_id;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.fecha = fecha;
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
}
