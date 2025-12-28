package com.backend.clasesya.repository;

import com.backend.clasesya.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {
}
