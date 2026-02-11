package com.devs.tutorsapp.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "tutor_materia",
        foreignKeys = {
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
            @Index("tutor_id"),
            @Index("materia_id")
        }
)
public class TutorMateriaEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int tutor_id;
    private int materia_id;

    public TutorMateriaEntity(int tutor_id, int materia_id) {
        this.tutor_id = tutor_id;
        this.materia_id = materia_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
