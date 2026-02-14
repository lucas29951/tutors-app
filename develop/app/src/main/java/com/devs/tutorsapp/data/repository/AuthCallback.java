package com.devs.tutorsapp.data.repository;

import com.devs.tutorsapp.data.local.entity.AlumnoEntity;

public interface AuthCallback {
    void onSuccess(AlumnoEntity alumno);
    void onError(String error);
}
