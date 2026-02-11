package com.devs.tutorsapp.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.lifecycle.LiveData;
import java.util.List;
import com.devs.tutorsapp.data.local.entity.MateriaEntity;

@Dao
public interface MateriaDao {

    @Insert
    long insertMateria(MateriaEntity materia);

    @Update
    void updateMateria(MateriaEntity materia);

    @Delete
    void deleteMateria(MateriaEntity materia);

    @Query("SELECT * FROM materias")
    LiveData<List<MateriaEntity>> getAllMaterias();

    @Query("SELECT * FROM materias WHERE materia_id = :materia_id")
    MateriaEntity getById(int materia_id);

}
