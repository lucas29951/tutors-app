package com.devs.tutorsapp.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.devs.tutorsapp.data.local.entity.ClaseEntity;
import com.devs.tutorsapp.data.local.entity.DisponibilidadEntity;
import com.devs.tutorsapp.data.local.entity.MateriaEntity;
import com.devs.tutorsapp.data.local.entity.TutorEntity;
import com.devs.tutorsapp.data.repository.ClaseRepository;
import com.devs.tutorsapp.data.repository.TutorRepository;

import java.util.List;
import java.util.concurrent.Executors;

public class ReservaClaseViewModel extends AuthViewModel {

    private TutorRepository tutorRepository;
    private ClaseRepository claseRepository;

    public ReservaClaseViewModel(@NonNull Application application) {
        super(application);
        tutorRepository = new TutorRepository(application);
        claseRepository = new ClaseRepository(application);
    }

    public LiveData<TutorEntity> getTutorById(int id) {
        return tutorRepository.getTutorById(id);
    }

    public LiveData<List<MateriaEntity>> getMateriasByTutor(int id) {
        return tutorRepository.getMateriasByTutor(id);
    }

    public LiveData<List<DisponibilidadEntity>> getDisponibilidadesByTutor(int id) {
        return tutorRepository.getDisponibilidadesByTutor(id);
    }

    public void insertarClase(ClaseEntity clase) {
        Executors.newSingleThreadExecutor().execute(() -> {
            claseRepository.crearClase(clase);
        });
    }

}
