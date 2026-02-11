package com.devs.tutorsapp.data.local.dao;

import com.devs.tutorsapp.data.local.entity.DisponibilidadEntity;
import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

@Dao
public interface DisponibilidadDao {

    @Insert
    long insertDisponibilidad(DisponibilidadEntity disponibilidad);

    @Update
    void updateDisponibilidad(DisponibilidadEntity disponibilidad);

    @Delete
    void deleteDisponibilidad(DisponibilidadEntity disponibilidad);

    @Query("SELECT * FROM disponibilidades")
    LiveData<List<DisponibilidadEntity>> getAllDisponibilidades();

    @Query("SELECT * FROM disponibilidades WHERE tutor_id = :tutor_id")
    LiveData<List<DisponibilidadEntity>> getDisponibilidadesByTutorId(int tutor_id);

}
