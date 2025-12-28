package com.backend.clasesya.repository;

import com.backend.clasesya.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.List;

public interface IHorarioRepository extends JpaRepository<Horario, Long> {

    List<Horario> findByProfesorIdAndDiaDisponible(Long profesorId, DayOfWeek diaDisponible);

    List<Horario> findByProfesorId(Long profesorId);

}
