package com.devs.tutorsapp.data.repository;

import android.content.Context;

import com.devs.tutorsapp.data.local.dao.ResenaDao;
import com.devs.tutorsapp.data.local.database.AppDatabase;
import com.devs.tutorsapp.data.local.entity.ResenaEntity;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ResenaRepository {

    public final ResenaDao resenaDao;
    public final ExecutorService executorService;

    public ResenaRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        resenaDao = db.resenaDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insertarResena(ResenaEntity resena) {
        executorService.execute(() -> resenaDao.insertResena(resena));
    }

    public void obtenerResenasPorTutor(int tutorId, RepositoryCallback<List<ResenaEntity>> callback) {
        executorService.execute(() -> {
            List<ResenaEntity> lista = (resenaDao.getResenasByTutorId(tutorId)).getValue();
            callback.onSuccess(lista);
        });
    }
}
