package com.devs.tutorsapp.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "materias")
public class MateriaEntity {

    @PrimaryKey(autoGenerate = true)
    private int materia_id;

    private String nombre;

    public MateriaEntity(String nombre) {
        this.nombre = nombre;
    }

    public int getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(int materia_id) {
        this.materia_id = materia_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
