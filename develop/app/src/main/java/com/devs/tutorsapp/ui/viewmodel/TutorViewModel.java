package com.devs.tutorsapp.ui.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devs.tutorsapp.data.local.entity.TutorEntity;
import com.devs.tutorsapp.data.repository.RepositoryCallback;
import com.devs.tutorsapp.data.repository.TutorRepository;

import java.util.List;

public class TutorViewModel extends AndroidViewModel {

    private final TutorRepository repository;
    private final MutableLiveData<List<TutorEntity>> listaTutores = new MutableLiveData<>();
    private final LiveData<List<TutorEntity>> allTutores;

    public TutorViewModel(@NonNull Application application) {
        super(application);
        repository = new TutorRepository(application);
        allTutores = repository.getAllTutores();
    }

    public LiveData<List<TutorEntity>> getListaTutores() {
        return listaTutores;
    }

    public void cargarTutores() {
        repository.obtenerTutores(new RepositoryCallback<List<TutorEntity>>() {
            @Override
            public void onSuccess(List<TutorEntity> result) {
                listaTutores.postValue(result);
            }

            @Override
            public void onError(String error) {
                Log.d("devtest", "Error al cargar los tutores");
            }
        });
    }

    public LiveData<List<TutorEntity>> getAllTutores() {
        return allTutores;
    }
}
