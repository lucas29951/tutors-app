package com.devs.tutorsapp.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;
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

}
