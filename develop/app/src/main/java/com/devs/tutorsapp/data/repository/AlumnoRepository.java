package com.devs.tutorsapp.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.devs.tutorsapp.data.local.dao.AlumnoDao;
import com.devs.tutorsapp.data.local.database.AppDatabase;
import com.devs.tutorsapp.data.local.entity.AlumnoEntity;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AlumnoRepository {

    private final AlumnoDao alumnoDao;
    private final ExecutorService executorService;

    public AlumnoRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        alumnoDao = db.alumnoDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<AlumnoEntity> getAlumnoById(int id) {
        return alumnoDao.getAlumnoById(id);
    }

}
