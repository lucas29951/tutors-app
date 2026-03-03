package com.devs.tutorsapp.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.devs.tutorsapp.data.local.entity.ClaseEntity;
import com.devs.tutorsapp.data.local.entity.MateriaEntity;
import com.devs.tutorsapp.data.local.entity.TutorEntity;
import com.devs.tutorsapp.data.repository.ClaseRepository;
import com.devs.tutorsapp.data.repository.MateriaRepository;
import com.devs.tutorsapp.data.repository.TutorRepository;

public class ClaseDetalleViewModel extends AndroidViewModel {

    private ClaseRepository claseRepository;
    private TutorRepository tutorRepository;
    private MateriaRepository materiaRepository;

    public ClaseDetalleViewModel(@NonNull Application application) {
        super(application);

        claseRepository = new ClaseRepository(application);
        tutorRepository = new TutorRepository(application);
        materiaRepository = new MateriaRepository(application);
    }

    public LiveData<ClaseEntity> getClaseById(int id) {
        return claseRepository.getClaseById(id);
    }

    public LiveData<TutorEntity> getTutorById(int id) {
        return tutorRepository.getTutorById(id);
    }

    public LiveData<MateriaEntity> getMateriaById(int id) {
        return materiaRepository.getMateriaById(id);
    }

}
