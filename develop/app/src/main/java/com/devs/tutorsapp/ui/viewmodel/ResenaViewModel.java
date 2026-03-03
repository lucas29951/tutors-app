package com.devs.tutorsapp.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.devs.tutorsapp.data.local.entity.ResenaEntity;
import com.devs.tutorsapp.data.repository.ResenaRepository;

public class ResenaViewModel extends AndroidViewModel {

    private ResenaRepository repository;

    public ResenaViewModel(@NonNull Application application) {
        super(application);
        repository = new ResenaRepository(application);
    }

    public void guardarResena(ResenaEntity resena) {
        repository.insertarResena(resena);
    }
}
