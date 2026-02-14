package com.devs.tutorsapp.ui.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devs.tutorsapp.data.local.entity.AlumnoEntity;
import com.devs.tutorsapp.data.repository.AuthCallback;
import com.devs.tutorsapp.data.repository.AuthRepository;


public class AuthViewModel extends AndroidViewModel {

    private final AuthRepository repository;
    private final MutableLiveData<String> successMessage = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final MutableLiveData<AlumnoEntity> alumno = new MutableLiveData<>();

    public AuthViewModel(@NonNull Application application) {
        super(application);
        repository = new AuthRepository(application);
    }

    public LiveData<String> getSuccessMessage() {
        return successMessage;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public LiveData<AlumnoEntity> getAlumno() {
        return alumno;
    }

    public void registrarAlumno(String nombre, String apellido, String email, String password, String telefono, String direccion, String foto) {
        repository.registrarAlumno(nombre, apellido, email, password, telefono, direccion, foto, new AuthCallback() {
            @Override
            public void onSuccess(AlumnoEntity a) {
                alumno.postValue(a);
                successMessage.postValue("Registro exitoso");
            }

            @Override
            public void onError(String error) {
                errorMessage.postValue(error);
            }
        });
    }

    public void login(String email, String password) {
        repository.login(email, password, new AuthCallback() {
            @Override
            public void onSuccess(AlumnoEntity a) {
                alumno.postValue(a);
                successMessage.postValue("Login exitoso");
            }

            @Override
            public void onError(String error) {
                errorMessage.postValue(error);
            }
        });
    }

}
