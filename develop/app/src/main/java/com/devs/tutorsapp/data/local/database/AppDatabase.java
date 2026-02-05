package com.devs.tutorsapp.data.local.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.devs.tutorsapp.data.local.dao.AlumnoDao;
import com.devs.tutorsapp.data.local.entity.AlumnoEntity;

@Database(entities = {AlumnoEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract AlumnoDao alumnoDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "teachme_database"
            ).fallbackToDestructiveMigration().build();
            android.util.Log.d("devtest", "Base de datos creada");
        }
        return INSTANCE;
    }

}
