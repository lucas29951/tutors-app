package com.devs.tutorsapp.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.devs.tutorsapp.data.local.entity.DisponibilidadEntity;
import com.devs.tutorsapp.data.local.entity.MateriaEntity;
import com.devs.tutorsapp.data.local.entity.TutorEntity;
import java.util.List;
import androidx.lifecycle.LiveData;


@Dao
public interface TutorDao {

    @Insert
    long insertTutor(TutorEntity tutor);

    @Update
    void updateTutor(TutorEntity tutor);

    @Delete
    void deleteTutor(TutorEntity tutor);

    @Query("SELECT * FROM tutores")
    LiveData<List<TutorEntity>> getAllTutores();

    @Query("SELECT * FROM tutores WHERE tutor_id = :tutor_id")
    TutorEntity getById(int tutor_id);

    @Query("SELECT * FROM tutores WHERE tutor_id = :tutor_id")
    LiveData<TutorEntity> getTutorById(int tutor_id);

    @Query("SELECT * FROM disponibilidades WHERE tutor_id = :tutorId")
    LiveData<List<DisponibilidadEntity>> getDisponibilidadesByTutor(int tutorId);

    @Query("SELECT m.* FROM materias m " + 
            "INNER JOIN tutor_materia tm ON m.materia_id = tm.materia_id " +
            "WHERE tm.tutor_id = :tutorId")
    LiveData<List<MateriaEntity>> getMateriasByTutor(int tutorId);

}
