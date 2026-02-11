package com.devs.tutorsapp.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "disponibilidades",
        foreignKeys = {
                @ForeignKey(
                        entity = TutorEntity.class,
                        parentColumns = "tutor_id",
                        childColumns = "tutor_id",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index("tutor_id")
        }
)
public class DisponibilidadEntity {
    @PrimaryKey(autoGenerate = true)
    private int disponibilidad_id;
    private int tutor_id;
    private String diaSemana;
    private String horaInicio;
    private String horaFin;

    public DisponibilidadEntity(int disponibilidad_id, int tutor_id, String diaSemana, String horaInicio, String horaFin) {
        this.disponibilidad_id = disponibilidad_id;
        this.tutor_id = tutor_id;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getDisponibilidad_id() {
        return disponibilidad_id;
    }

    public void setDisponibilidad_id(int disponibilidad_id) {
        this.disponibilidad_id = disponibilidad_id;
    }

    public int getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(int tutor_id) {
        this.tutor_id = tutor_id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
}
