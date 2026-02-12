package com.devs.tutorsapp.data.repository;

public interface AuthCallback {
    void onSuccess(String message);
    void onError(String error);
}
