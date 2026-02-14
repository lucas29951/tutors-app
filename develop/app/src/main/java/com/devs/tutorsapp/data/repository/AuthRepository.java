package com.devs.tutorsapp.data.repository;

import android.content.Context;

import com.devs.tutorsapp.data.local.dao.AlumnoDao;
import com.devs.tutorsapp.data.local.database.AppDatabase;
import com.devs.tutorsapp.data.local.entity.AlumnoEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AuthRepository {

    private final AlumnoDao alumnoDao;
    private final ExecutorService executorService;

    public AuthRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        alumnoDao = db.alumnoDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void registrarAlumno(String nombre, String apellido, String email, String password, String telefono, String direccion, String foto, AuthCallback callback) {
        executorService.execute(() -> {
            AlumnoEntity exist = alumnoDao.getAlumnoByEmail(email);

            if (exist != null) {
                callback.onError("El email ya esta registrado");
                return;
            }

            AlumnoEntity alumno = new AlumnoEntity(nombre, apellido, email, password, telefono, direccion, foto);

            alumnoDao.insertAlumno(alumno);
            callback.onSuccess(alumno);
        });
    }

    public void login(String email, String password, AuthCallback callback) {
        executorService.execute(() -> {
            AlumnoEntity alumno = alumnoDao.getAlumnoByEmail(email);

            if (alumno == null) {
                callback.onError("Usuario no encontrado");
                return;
            }

            if (!alumno.getPassword().equals(password)) {
                callback.onError("Cantraseña incorrecta");
                return;
            }

            callback.onSuccess(alumno);
        });
    }
}
