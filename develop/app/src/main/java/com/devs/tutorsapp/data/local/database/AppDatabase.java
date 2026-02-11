package com.devs.tutorsapp.data.local.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.devs.tutorsapp.data.local.dao.AlumnoDao;
import com.devs.tutorsapp.data.local.dao.ClaseDao;
import com.devs.tutorsapp.data.local.dao.DisponibilidadDao;
import com.devs.tutorsapp.data.local.dao.MateriaDao;
import com.devs.tutorsapp.data.local.dao.ResenaDao;
import com.devs.tutorsapp.data.local.dao.TutorDao;
import com.devs.tutorsapp.data.local.dao.TutorMateriaDao;
import com.devs.tutorsapp.data.local.entity.AlumnoEntity;
import com.devs.tutorsapp.data.local.entity.ClaseEntity;
import com.devs.tutorsapp.data.local.entity.DisponibilidadEntity;
import com.devs.tutorsapp.data.local.entity.MateriaEntity;
import com.devs.tutorsapp.data.local.entity.ResenaEntity;
import com.devs.tutorsapp.data.local.entity.TutorEntity;
import com.devs.tutorsapp.data.local.entity.TutorMateriaEntity;

@Database(
        entities = {
                AlumnoEntity.class,
                TutorEntity.class,
                MateriaEntity.class,
                TutorMateriaEntity.class,
                DisponibilidadEntity.class,
                ClaseEntity.class,
                ResenaEntity.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract AlumnoDao alumnoDao();
    public abstract TutorDao tutorDao();
    public abstract MateriaDao materiaDao();
    public abstract DisponibilidadDao disponibilidadDao();
    public abstract ClaseDao claseDao();
    public abstract ResenaDao resenaDao();
    public abstract TutorMateriaDao tutorMateriaDao();

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
