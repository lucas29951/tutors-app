package com.devs.tutorsapp.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.lifecycle.LiveData;
import java.util.List;
import com.devs.tutorsapp.data.local.entity.ClaseEntity;
import com.devs.tutorsapp.data.model.ClaseDetalle;

@Dao
public interface ClaseDao {

    @Insert
    long insertClase(ClaseEntity clase);

    @Update
    void updateClase(ClaseEntity clase);

    @Delete
    void deleteClase(ClaseEntity clase);

    @Query("SELECT * FROM clases")
    LiveData<List<ClaseEntity>> getAllClases();

    @Query("SELECT * FROM clases WHERE clase_id = :clase_id")
    ClaseEntity getById(int clase_id);

    @Query("SELECT * FROM clases WHERE alumno_id = :alumno_id")
    LiveData<List<ClaseEntity>> getClasesByAlumnoId(int alumno_id);

    @Query("SELECT * FROM clases WHERE tutor_id = :tutor_id")
    LiveData<List<ClaseEntity>> getClasesByTutorId(int tutor_id);

    @Query("SELECT * FROM clases WHERE estado = :estado")
    LiveData<List<ClaseEntity>> getClasesByEstado(String estado);

    @Query("SELECT * FROM clases WHERE estado = :estado AND alumno_id = :alumno_id")
    LiveData<List<ClaseEntity>> getClasesByEstadoAndAlumnoId(String estado, int alumno_id);

    @Query("SELECT c.clase_id, c.fecha, c.hora_inicio, c.estado, " +
            "t.nombre AS tutorNombre, t.apellido AS tutorApellido, " +
            "m.nombre AS materiaNombre " +
            "FROM clases c " +
            "INNER JOIN tutores t ON c.tutor_id = t.tutor_id " +
            "INNER JOIN materias m ON c.materia_id = m.materia_id" +
            " WHERE c.estado = :estado AND c.alumno_id = :alumno_id")
    LiveData<List<ClaseDetalle>> getClasesConDetalles(String estado, int alumno_id);
}
