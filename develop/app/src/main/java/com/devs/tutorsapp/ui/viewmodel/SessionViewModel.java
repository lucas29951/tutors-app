package com.devs.tutorsapp.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SessionViewModel extends ViewModel {

    private final MutableLiveData<Integer> alumnoId = new MutableLiveData<>();
    private final MutableLiveData<String> alumnoNombre = new MutableLiveData<>();
    private final MutableLiveData<String> alumnoEmail = new MutableLiveData<>();

    public void setAlumno(int id, String nom, String correo) {
        alumnoId.setValue(id);
        alumnoNombre.setValue(nom);
        alumnoEmail.setValue(correo);
    }

    public LiveData<Integer> getAlumnoId() {
        return alumnoId;
    }

    public LiveData<String> getAlumnoNombre() {
        return alumnoNombre;
    }

    public LiveData<String> getAlumnoEmail() {
        return alumnoEmail;
    }
}
