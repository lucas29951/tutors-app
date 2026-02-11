package com.devs.tutorsapp.data.local.dao;

import androidx.lifecycle.LiveData;
import java.util.List;
import com.devs.tutorsapp.data.local.entity.ResenaEntity;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

@Dao
public interface ResenaDao {

    @Insert
    long insertResena(ResenaEntity resena);

    @Update
    void updateResena(ResenaEntity resena);

    @Delete
    void deleteResena(ResenaEntity resena);

    @Query("SELECT * FROM resenas")
    LiveData<List<ResenaEntity>> getAllResenas();

    @Query("SELECT * FROM resenas WHERE tutor_id = :tutor_id")
    LiveData<List<ResenaEntity>> getResenasByTutorId(int tutor_id);

    @Query("SELECT * FROM resenas WHERE alumno_id = :alumno_id")
    LiveData<List<ResenaEntity>> getResenasByAlumnoId(int alumno_id);

}
