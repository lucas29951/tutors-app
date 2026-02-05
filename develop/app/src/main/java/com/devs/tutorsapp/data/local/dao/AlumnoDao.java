package com.devs.tutorsapp.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.devs.tutorsapp.data.local.entity.AlumnoEntity;
import java.util.List;

@Dao
public interface AlumnoDao {

    @Insert
    void insertAlumno(AlumnoEntity alumno);

    @Query("SELECT * FROM alumnos")
    LiveData<List<AlumnoEntity>> getAllAlumnos();

    @Query("SELECT * FROM alumnos WHERE email = :email AND password = :password")
    AlumnoEntity getAlumnoByEmailAndPassword(String email, String password);

    @Query("DELETE FROM alumnos WHERE alumno_id = :alumnoId")
    void deleteAlumnoById(int alumnoId);
}
