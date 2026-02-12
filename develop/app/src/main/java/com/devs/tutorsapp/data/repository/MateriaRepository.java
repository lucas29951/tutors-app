package com.devs.tutorsapp.data.repository;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.content.Context;

import com.devs.tutorsapp.data.local.dao.MateriaDao;
import com.devs.tutorsapp.data.local.database.AppDatabase;
import com.devs.tutorsapp.data.local.entity.MateriaEntity;

public class MateriaRepository {

    private final MateriaDao materiaDao;
    private final ExecutorService executorService;

    public MateriaRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        materiaDao = db.materiaDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insertarMateria(MateriaEntity materia) {
        executorService.execute(() -> materiaDao.insertMateria(materia));
    }

    public void obtenerMaterias(RepositoryCallback<List<MateriaEntity>> callback) {
        executorService.execute(() -> {
            List<MateriaEntity> lista = (materiaDao.getAllMaterias()).getValue();
            callback.onSuccess(lista);
        });
    }
}
