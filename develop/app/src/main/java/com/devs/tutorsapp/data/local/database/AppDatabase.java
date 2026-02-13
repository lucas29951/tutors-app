package com.devs.tutorsapp.data.local.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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

import java.util.concurrent.Executors;

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

    private static volatile AppDatabase INSTANCE;

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
            )
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
            android.util.Log.d("devtest", "Base de datos creada");
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            Executors.newSingleThreadExecutor().execute(() -> {
                AppDatabase database = INSTANCE;

                prepopulate(database);
            });
        }
    };

    private static void prepopulate(AppDatabase database) {

        MateriaEntity matematica = new MateriaEntity("Matematica", "Clases de Algebra y Analisis Matematico");
        MateriaEntity programacion = new MateriaEntity("Programacion", "Java y Desarrollo Android");

        database.materiaDao().insertMateria(matematica);
        database.materiaDao().insertMateria(programacion);

        TutorEntity tutor1 = new TutorEntity("Carlos", "Gomez", "carlos@gmail.com", "123456789", "Profesor de matematica con 10 años de experiencia.", "", "Buenos Aires 123");
        TutorEntity tutor2 = new TutorEntity("Laura", "Martinez", "laura@gmail.com", "987654321", "Desarrolladora Android y profesora universitaria.", "", "Cordoba 456");

        long tutor1Id = database.tutorDao().insertTutor(tutor1);
        long tutor2Id = database.tutorDao().insertTutor(tutor2);

        database.tutorMateriaDao().insertTutorMateria(new TutorMateriaEntity((int) tutor1Id, 1));
        database.tutorMateriaDao().insertTutorMateria(new TutorMateriaEntity((int) tutor2Id, 2));

    }

}
