package com.devs.tutorsapp.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.lifecycle.LiveData;
import java.util.List;
import com.devs.tutorsapp.data.local.entity.ClaseEntity;

@Dao
public interface ClaseDao {

    @Insert
    long insertClase(ClaseEntity clase);

    @Update
    void updateClase(ClaseEntity clase);

    @Delete
    void deleteClase(ClaseEntity clase);

    @Query("SELECT * FROM clases")
    LiveData<List<ClaseEntity>> getAllClases();

    @Query("SELECT * FROM clases WHERE clase_id = :clase_id")
    ClaseEntity getById(int clase_id);

    @Query("SELECT * FROM clases WHERE alumno_id = :alumno_id")
    LiveData<List<ClaseEntity>> getClasesByAlumnoId(int alumno_id);

    @Query("SELECT * FROM clases WHERE tutor_id = :tutor_id")
    LiveData<List<ClaseEntity>> getClasesByTutorId(int tutor_id);

}
