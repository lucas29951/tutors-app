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

import java.util.concurrent.ExecutorService;
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
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


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
                    .addCallback(roomCallback(context))
                    .build();
            android.util.Log.d("devtest", "Base de datos creada");
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallback(Context context) {
        return new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                databaseWriteExecutor.execute(() -> {
                    AppDatabase database = getInstance(context);
                    prepopulate(database);
                });
            }
        };
    }

    private static void prepopulate(AppDatabase database) {
        android.util.Log.d("devtest", "Ejecutando precarga de datos..");

        MateriaDao materiaDao = database.materiaDao();
        TutorDao tutorDao = database.tutorDao();

        android.util.Log.d("devtest", "Cargando materias...");

        materiaDao.insertMateria(new MateriaEntity("Matemática"));
        materiaDao.insertMateria(new MateriaEntity("Física"));
        materiaDao.insertMateria(new MateriaEntity("Química"));
        materiaDao.insertMateria(new MateriaEntity("Biología"));
        materiaDao.insertMateria(new MateriaEntity("Historia"));
        materiaDao.insertMateria(new MateriaEntity("Geografía"));
        materiaDao.insertMateria(new MateriaEntity("Inglés"));
        materiaDao.insertMateria(new MateriaEntity("Programación"));
        materiaDao.insertMateria(new MateriaEntity("Álgebra"));
        materiaDao.insertMateria(new MateriaEntity("Estadística"));

        android.util.Log.d("devtest", "Cargando Tutores...");

        tutorDao.insertTutor(new TutorEntity("Carlos", "Pérez", "carlos.perez@gmail.com", "1234567890", "", "", "", 19, 5));
        tutorDao.insertTutor(new TutorEntity("Laura", "Gómez", "laura.gomez@gmail.com", "9876543210", "", "", "", 21, 3));
        tutorDao.insertTutor(new TutorEntity("María", "Díaz", "maria.diaz@gmail.com", "5555555555", "", "", "", 60, 7));
        tutorDao.insertTutor(new TutorEntity("Javier", "López", "javier.lopez@gmail.com", "9999999999", "", "", "", 32, 8));
        tutorDao.insertTutor(new TutorEntity("Ana", "Martínez", "ana.martinez@gmail.com", "7777777777", "", "", "", 42, 7));
        tutorDao.insertTutor(new TutorEntity("Pedro", "Sánchez", "pedro.sanchez@gmail.com", "4444444444", "", "", "", 25, 6));
        tutorDao.insertTutor(new TutorEntity("Lucía", "Fernández", "lucia.fernandez@gmail.com", "2222222222", "", "", "", 21, 7));
        tutorDao.insertTutor(new TutorEntity("Diego", "Ramírez", "diego.ramirez@gmail.com", "8888888888", "", "", "", 34, 7));
        tutorDao.insertTutor(new TutorEntity("Sofía", "Torres", "sofia.torres@gmail.com", "6666666666", "", "", "", 27, 6));
        tutorDao.insertTutor(new TutorEntity("Martín", "Castro", "martin.castro@gmail.com", "3333333333", "", "", "", 30, 8));
        tutorDao.insertTutor(new TutorEntity("Valentina", "Ruiz", "valentina.ruiz@gmail.com", "1111111111", "", "", "", 13, 7));
        tutorDao.insertTutor(new TutorEntity("Andrés", "Morales", "andres.morales@gmail.com", "0000000000", "", "", "", 15, 6));
        tutorDao.insertTutor(new TutorEntity("Camila", "Herrera", "camila.herrera@gmail.com", "9453299999", "", "", "", 23, 5));
        tutorDao.insertTutor(new TutorEntity("Nicolás", "Vega", "nicolas.vega@gmail.com", "3257294389", "", "", "", 36, 7));
        tutorDao.insertTutor(new TutorEntity("Paula", "Rojas", "paula.rojas@gmail.com", "8539605098", "", "", "", 12, 6));

    }

}
