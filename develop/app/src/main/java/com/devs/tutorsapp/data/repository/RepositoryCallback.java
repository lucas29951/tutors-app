package com.devs.tutorsapp.data.repository;

public interface RepositoryCallback<T> {
    void onSuccess(T result);
    void onError(String error);
}
