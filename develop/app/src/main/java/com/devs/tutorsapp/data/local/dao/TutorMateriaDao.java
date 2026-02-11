package com.devs.tutorsapp.data.local.dao;

import com.devs.tutorsapp.data.local.entity.TutorMateriaEntity;
import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

@Dao
public interface TutorMateriaDao {

    @Insert
    long insertTutorMateria(TutorMateriaEntity tutorMateria);

    @Delete
    void deleteTutorMateria(TutorMateriaEntity tutorMateria);

    @Query("SELECT * FROM tutor_materia WHERE tutor_id = :tutor_id")
    LiveData<List<TutorMateriaEntity>> getMateriasByTutorId(int tutor_id);

    @Query("SELECT * FROM tutor_materia WHERE materia_id = :materia_id")
    LiveData<List<TutorMateriaEntity>> getTutoresByMateriaId(int materia_id);

}
