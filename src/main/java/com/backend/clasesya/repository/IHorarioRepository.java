package com.backend.clasesya.repository;

import com.backend.clasesya.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IHorarioRepository extends JpaRepository<Horario, Long> {

    List<Horario> findByProfesorIdAndDiaDisponible(Long profesorId, DayOfWeek diaDisponible);

    List<Horario> findByProfesorId(Long profesorId);

    // Para cuando tenga la entidad Clase lista.
    // List<Horario> findDisponibleByDia(LocalDate dia);

}
