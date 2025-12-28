package com.backend.clasesya.repository;

import com.backend.clasesya.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfesorRepository extends JpaRepository<Profesor, Long> {
}
