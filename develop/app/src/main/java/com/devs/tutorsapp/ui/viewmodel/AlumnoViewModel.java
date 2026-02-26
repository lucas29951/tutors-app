package com.devs.tutorsapp.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.devs.tutorsapp.data.local.entity.AlumnoEntity;
import com.devs.tutorsapp.data.repository.AlumnoRepository;

public class AlumnoViewModel extends AndroidViewModel {

    private final AlumnoRepository repository;

    public AlumnoViewModel(@NonNull Application application) {
        super(application);
        repository = new AlumnoRepository(application);
    }

    public LiveData<AlumnoEntity> getAlumnoById(int id) {
        return repository.getAlumnoById(id);
    }
}
