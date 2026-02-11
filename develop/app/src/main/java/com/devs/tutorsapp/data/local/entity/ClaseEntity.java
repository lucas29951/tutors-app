package com.devs.tutorsapp.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Index;
import androidx.room.ForeignKey;


@Entity(tableName = "clases",
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
                ),
                @ForeignKey(
                        entity = MateriaEntity.class,
                        parentColumns = "materia_id",
                        childColumns = "materia_id",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
            @Index("alumno_id"),
            @Index("tutor_id"),
            @Index("materia_id")
        }
)
public class ClaseEntity {

    @PrimaryKey(autoGenerate = true)
    private int clase_id;

    private int alumno_id;
    private int tutor_id;
    private int materia_id;

    private String fecha;
    private String hora_inicio;
    private int duracion;
    private String estado;

    public ClaseEntity(int alumno_id, int tutor_id, int materia_id, String fecha, String hora_inicio, int duracion, String estado) {
        this.alumno_id = alumno_id;
        this.tutor_id = tutor_id;
        this.materia_id = materia_id;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.duracion = duracion;
        this.estado = estado;
    }

    public int getClase_id() {
        return clase_id;
    }

    public void setClase_id(int clase_id) {
        this.clase_id = clase_id;
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

    public int getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(int materia_id) {
        this.materia_id = materia_id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
