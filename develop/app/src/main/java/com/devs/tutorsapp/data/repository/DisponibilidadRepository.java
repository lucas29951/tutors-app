package com.devs.tutorsapp.data.repository;

import android.content.Context;

import com.devs.tutorsapp.data.local.dao.DisponibilidadDao;
import com.devs.tutorsapp.data.local.database.AppDatabase;
import com.devs.tutorsapp.data.local.entity.DisponibilidadEntity;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class DisponibilidadRepository {

    private final DisponibilidadDao disponibilidadDao;
    private final ExecutorService executorService;

    public DisponibilidadRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        disponibilidadDao = db.disponibilidadDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insertarDisponibilidad(DisponibilidadEntity disponibilidad) {
        executorService.execute(() -> disponibilidadDao.insertDisponibilidad(disponibilidad));
    }

    public void obtenerDisponibilidadPorTutor(int tutorId, RepositoryCallback<List<DisponibilidadEntity>> callback) {
        executorService.execute(() -> {
            List<DisponibilidadEntity> lista = (disponibilidadDao.getDisponibilidadesByTutorId(tutorId)).getValue();
            callback.onSuccess(lista);
        });
    }
}
