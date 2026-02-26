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
        AlumnoDao alumnoDao = database.alumnoDao();
        ClaseDao claseDao = database.claseDao();
        DisponibilidadDao disponibilidadDao = database.disponibilidadDao();
        TutorMateriaDao tutorMateriaDao = database.tutorMateriaDao();

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

        tutorDao.insertTutor(new TutorEntity("Carlos", "Pérez", "carlos.perez@gmail.com", "1234567890",
                "Av. Rivadavia 1234, Buenos Aires",
                "",
                "Profesor de Matemáticas con enfoque práctico. Ayuda a estudiantes secundarios y universitarios a mejorar su rendimiento.",
                19, 5));

        tutorDao.insertTutor(new TutorEntity("Laura", "Gómez", "laura.gomez@gmail.com", "9876543210",
                "Calle San Martín 456, Córdoba",
                "",
                "Especialista en Lengua y Literatura. Clases dinámicas para mejorar redacción, comprensión y análisis de textos.",
                21, 3));

        tutorDao.insertTutor(new TutorEntity("María", "Díaz", "maria.diaz@gmail.com", "5555555555",
                "Av. Belgrano 789, Rosario",
                "",
                "Profesora de Física con amplia experiencia. Explicaciones claras y resolución paso a paso de problemas complejos.",
                60, 7));

        tutorDao.insertTutor(new TutorEntity("Javier", "López", "javier.lopez@gmail.com", "9999999999",
                "Calle Mitre 321, Mendoza",
                "",
                "Tutor de Programación (Java y Python). Ideal para principiantes y estudiantes universitarios.",
                32, 8));

        tutorDao.insertTutor(new TutorEntity("Ana", "Martínez", "ana.martinez@gmail.com", "7777777777",
                "Av. Colón 654, Córdoba",
                "",
                "Docente de Inglés con enfoque conversacional. Mejora tu speaking y comprensión auditiva.",
                42, 7));

        tutorDao.insertTutor(new TutorEntity("Pedro", "Sánchez", "pedro.sanchez@gmail.com", "4444444444",
                "Calle Sarmiento 987, La Plata",
                "",
                "Profesor de Historia apasionado. Clases didácticas para secundaria y preparación de exámenes.",
                25, 6));

        tutorDao.insertTutor(new TutorEntity("Lucía", "Fernández", "lucia.fernandez@gmail.com", "2222222222",
                "Av. Alem 741, Bahía Blanca",
                "",
                "Especialista en Química. Explica conceptos difíciles de forma sencilla y práctica.",
                21, 7));

        tutorDao.insertTutor(new TutorEntity("Diego", "Ramírez", "diego.ramirez@gmail.com", "8888888888",
                "Calle Urquiza 852, Tucumán",
                "",
                "Tutor de Matemáticas avanzadas. Ideal para ingresos universitarios y materias complejas.",
                34, 7));

        tutorDao.insertTutor(new TutorEntity("Sofía", "Torres", "sofia.torres@gmail.com", "6666666666",
                "Av. San Juan 963, Buenos Aires",
                "",
                "Profesora de Biología. Clases claras con ejemplos prácticos y apoyo para exámenes.",
                27, 6));

        tutorDao.insertTutor(new TutorEntity("Martín", "Castro", "martin.castro@gmail.com", "3333333333",
                "Calle España 159, Salta",
                "",
                "Docente de Economía y Contabilidad. Explicaciones simples y aplicadas a la vida real.",
                30, 8));

        tutorDao.insertTutor(new TutorEntity("Valentina", "Ruiz", "valentina.ruiz@gmail.com", "1111111111",
                "Av. Libertad 753, Mar del Plata",
                "",
                "Estudiante avanzada que brinda apoyo en materias básicas. Ideal para nivel primario y secundario.",
                13, 7));

        tutorDao.insertTutor(new TutorEntity("Andrés", "Morales", "andres.morales@gmail.com", "0000000000",
                "Calle Pellegrini 246, Santa Fe",
                "",
                "Tutor de Geografía. Clases dinámicas con mapas y ejemplos prácticos.",
                15, 6));

        tutorDao.insertTutor(new TutorEntity("Camila", "Herrera", "camila.herrera@gmail.com", "9453299999",
                "Av. San Martín 852, Neuquén",
                "",
                "Profesora de Inglés enfocada en gramática y escritura. Ideal para exámenes internacionales.",
                23, 5));

        tutorDao.insertTutor(new TutorEntity("Nicolás", "Vega", "nicolas.vega@gmail.com", "3257294389",
                "Calle Lavalle 369, Buenos Aires",
                "",
                "Tutor de Programación web (HTML, CSS, JS). Aprende creando proyectos reales.",
                36, 7));

        tutorDao.insertTutor(new TutorEntity("Paula", "Rojas", "paula.rojas@gmail.com", "8539605098",
                "Av. Moreno 147, Córdoba",
                "",
                "Profesora de Psicología. Clases claras y acompañamiento en trabajos prácticos.",
                12, 6));

        android.util.Log.d("devtest", "Cargando Alumnos...");

        alumnoDao.insertAlumno(new AlumnoEntity("Lucia", "Robles", "luciar@gmail.com", "lucia123", "837462954", "Calle Rivadavia 195, Tucuman", ""));
        alumnoDao.insertAlumno(new AlumnoEntity("Sofía", "López", "sofial@gmail.com", "sofia123", "940988640", "Av. Bolivia 315, Salta", ""));
        alumnoDao.insertAlumno(new AlumnoEntity("Martín", "Díaz", "martind@gmail.com", "martin123", "651950034", "Av. Belgrano 21, Santiago del Estero", ""));
        alumnoDao.insertAlumno(new AlumnoEntity("Camila", "Torres", "camilat@gmail.com", "cami123", "610599538", "Calle Congreso 54, San Luis", ""));
        alumnoDao.insertAlumno(new AlumnoEntity("Pedro", "Gómez", "pedrog@gmail.com", "pedro123", "881044325", "Calle Punilla 92, Cordoba", ""));

        android.util.Log.d("devtest", "Cargando clases...");

        claseDao.insertClase(new ClaseEntity(1, 1, 3, "2024-06-15", "19:15", 1, "Pending"));
        claseDao.insertClase(new ClaseEntity(1, 2, 6, "2024-06-16", "09:30", 2, "Confirmed"));
        claseDao.insertClase(new ClaseEntity(1, 3, 7, "2024-06-17", "12:45", 1, "Completed"));

        claseDao.insertClase(new ClaseEntity(2, 1, 3, "2024-06-18", "13:00", 3, "Pending"));
        claseDao.insertClase(new ClaseEntity(2, 2, 8, "2024-06-19", "17:30", 1, "Confirmed"));

        claseDao.insertClase(new ClaseEntity(3, 3, 9, "2024-06-20", "20:00", 3, "Completed"));
        claseDao.insertClase(new ClaseEntity(3, 1, 4, "2024-06-21", "11:40", 2, "Pending"));

        android.util.Log.d("devtest", "Cargando disponibilidades...");

        disponibilidadDao.insertDisponibilidad(new DisponibilidadEntity(2, "Lunes", "17:45", "19:00"));
        disponibilidadDao.insertDisponibilidad(new DisponibilidadEntity(6, "Jueves", "08:15", "12:30"));
        disponibilidadDao.insertDisponibilidad(new DisponibilidadEntity(3, "Miercoles", "13:00", "15:45"));
        disponibilidadDao.insertDisponibilidad(new DisponibilidadEntity(10, "Martes", "19:20", "21:15"));
        disponibilidadDao.insertDisponibilidad(new DisponibilidadEntity(7, "Jueves", "10:40", "13:35"));
        disponibilidadDao.insertDisponibilidad(new DisponibilidadEntity(1, "Viernes", "11:30", "14:50"));
        disponibilidadDao.insertDisponibilidad(new DisponibilidadEntity(12, "Martes", "08:50", "10:30"));

        android.util.Log.d("devtest", "Cargando tutor-materias...");

        tutorMateriaDao.insertTutorMateria(new TutorMateriaEntity(2, 3));
        tutorMateriaDao.insertTutorMateria(new TutorMateriaEntity(6, 1));
        tutorMateriaDao.insertTutorMateria(new TutorMateriaEntity(3, 7));
        tutorMateriaDao.insertTutorMateria(new TutorMateriaEntity(10, 4));
        tutorMateriaDao.insertTutorMateria(new TutorMateriaEntity(7, 9));
        tutorMateriaDao.insertTutorMateria(new TutorMateriaEntity(1, 5));
        tutorMateriaDao.insertTutorMateria(new TutorMateriaEntity(12, 8));
    }

}
