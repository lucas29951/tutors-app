package com.devs.tutorsapp.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.AndroidViewModel;
import androidx.annotation.NonNull;
import android.app.Application;
import android.util.Log;

import com.devs.tutorsapp.data.local.entity.ClaseEntity;
import com.devs.tutorsapp.data.repository.ClaseRepository;
import com.devs.tutorsapp.data.repository.RepositoryCallback;

import java.util.List;


public class ClaseViewModel extends AndroidViewModel {

    private final ClaseRepository repository;
    private final MutableLiveData<List<ClaseEntity>> listaClases = new MutableLiveData<>();

    public ClaseViewModel(@NonNull Application application) {
        super(application);
        repository = new ClaseRepository(application);
    }

    public LiveData<List<ClaseEntity>> getListaClases() {
        return listaClases;
    }

    public void cargarClasesPorAlumno(int alumnoId) {
        repository.obtenerClasesPorAlumno(alumnoId, new RepositoryCallback<List<ClaseEntity>>() {
            @Override
            public void onSuccess(List<ClaseEntity> result) {
                listaClases.postValue(result);
            }

            @Override
            public void onError(String error) {
                Log.d("devtest", "Error al cargar las clases");
            }
        });
    }

    public void crearClase(ClaseEntity clase) {
        repository.crearClase(clase);
    }

    public LiveData<List<ClaseEntity>> getClasesByEstado(String status) {
        return repository.getClasesByEstado(status);
    }

    public LiveData<List<ClaseEntity>> getClasesByEstadoAndAlumnoId(String status, int alumnoId) {
        return repository.getClasesByEstadoAndAlumnoId(status, alumnoId);
    }

}
