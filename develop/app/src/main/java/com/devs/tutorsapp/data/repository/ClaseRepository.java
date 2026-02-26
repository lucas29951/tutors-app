package com.devs.tutorsapp.data.repository;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.List;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.devs.tutorsapp.data.local.dao.ClaseDao;
import com.devs.tutorsapp.data.local.database.AppDatabase;
import com.devs.tutorsapp.data.local.entity.ClaseEntity;
import com.devs.tutorsapp.data.model.ClaseDetalle;

public class ClaseRepository {

    private final ClaseDao claseDao;
    private final ExecutorService executorService;

    public ClaseRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        claseDao = db.claseDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void crearClase(ClaseEntity clase) {
        executorService.execute(() -> claseDao.insertClase(clase));
    }

    public void obtenerClasesPorAlumno(int alumnoId, RepositoryCallback<List<ClaseEntity>> callback) {
        executorService.execute(() -> {
            List<ClaseEntity> lista = (claseDao.getClasesByAlumnoId(alumnoId)).getValue();
            callback.onSuccess(lista);
        });
    }

    public void obtenerClasesPorTutor(int tutorId, RepositoryCallback<List<ClaseEntity>> callback) {
        executorService.execute(() -> {
            List<ClaseEntity> lista = (claseDao.getClasesByTutorId(tutorId)).getValue();
            callback.onSuccess(lista);
        });
    }

    public LiveData<List<ClaseEntity>> getClasesByEstado(String status) {
        return claseDao.getClasesByEstado(status);
    }

    public LiveData<List<ClaseEntity>> getClasesByEstadoAndAlumnoId(String status, int alumnoId) {
        return claseDao.getClasesByEstadoAndAlumnoId(status, alumnoId);
    }

    public LiveData<List<ClaseDetalle>> getClasesConDetalles(String estado, int alumno_id) {
        return claseDao.getClasesConDetalles(estado, alumno_id);
    }

}
