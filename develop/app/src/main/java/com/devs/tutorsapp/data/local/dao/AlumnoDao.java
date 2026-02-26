package com.devs.tutorsapp.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.devs.tutorsapp.data.local.entity.AlumnoEntity;
import java.util.List;

@Dao
public interface AlumnoDao {

    @Insert
    long insertAlumno(AlumnoEntity alumno);

    @Update
    void updateAlumno(AlumnoEntity alumno);

    @Delete
    void deleteAlumno(AlumnoEntity alumno);

    @Query("SELECT * FROM alumnos")
    LiveData<List<AlumnoEntity>> getAllAlumnos();

    @Query("SELECT * FROM alumnos WHERE alumno_id = :alumno_id")
    AlumnoEntity getById(int alumno_id);

    @Query("SELECT * FROM alumnos WHERE email = :email LIMIT 1")
    AlumnoEntity getAlumnoByEmail(String email);

    @Query("SELECT * FROM alumnos WHERE email = :email AND password = :password")
    AlumnoEntity getAlumnoByEmailAndPassword(String email, String password);

    @Query("DELETE FROM alumnos WHERE alumno_id = :alumnoId")
    void deleteAlumnoById(int alumnoId);

    @Query("SELECT * FROM alumnos WHERE alumno_id = :alumno_id")
    LiveData<AlumnoEntity> getAlumnoById(int alumno_id);
}
