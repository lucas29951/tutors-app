package com.devs.tutorsapp.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.devs.tutorsapp.data.local.dao.TutorDao;
import com.devs.tutorsapp.data.local.database.AppDatabase;
import com.devs.tutorsapp.data.local.entity.TutorEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TutorRepository {

    private final TutorDao tutorDao;
    private final ExecutorService executorService;

    public TutorRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        tutorDao = db.tutorDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insertarTutor(TutorEntity tutor) {
        executorService.execute(() -> tutorDao.insertTutor(tutor));
    }

    public void obtenerTutores(RepositoryCallback<List<TutorEntity>> callback) {
        executorService.execute(() -> {
            List<TutorEntity> lista = (tutorDao.getAllTutores()).getValue();
            callback.onSuccess(lista);
        });
    }

    public LiveData<List<TutorEntity>> getAllTutores() {
        return tutorDao.getAllTutores();
    }
}
