package com.devs.tutorsapp;

import android.app.Application;
import com.devs.tutorsapp.data.local.database.AppDatabase;

public class TeachMeApplication extends Application {

    private static TeachMeApplication instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        android.util.Log.d("devtest", "Application iniciada");

        AppDatabase.databaseWriteExecutor.execute(() -> {
            database = AppDatabase.getInstance(this);
            database.alumnoDao().getAlumnoByEmail("");
            android.util.Log.d("devtest", "Base de datos inicializada");
        });
    }

    public static TeachMeApplication getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
