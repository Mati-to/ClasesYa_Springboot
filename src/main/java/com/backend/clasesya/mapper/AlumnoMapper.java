package com.backend.clasesya.mapper;

import com.backend.clasesya.dto.alumno.AlumnoCreateDTO;
import com.backend.clasesya.dto.alumno.AlumnoResponseDTO;
import com.backend.clasesya.dto.alumno.AlumnoUpdateDTO;
import com.backend.clasesya.entity.Alumno;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AlumnoMapper {

    public Alumno toAlumno(AlumnoCreateDTO dto) {
        Alumno alumno = new Alumno();
        alumno.setNombre(dto.getNombre());
        alumno.setCorreo(dto.getCorreo());
        alumno.setContrasena(dto.getContrasena());
        alumno.setFechaRegistro(LocalDate.now());
        return alumno;
    }

    public AlumnoResponseDTO toAlumnoDto(Alumno alumno) {
        AlumnoResponseDTO dto = new AlumnoResponseDTO();
        dto.setId(alumno.getId());
        dto.setNombre(alumno.getNombre());
        dto.setCorreo(alumno.getCorreo());
        dto.setFechaRegistro(alumno.getFechaRegistro());
        return dto;
    }

    public void toUpdateAlumno(Alumno alumno, AlumnoUpdateDTO dto) {
        alumno.setNombre(dto.getNombre());
        alumno.setCorreo(dto.getCorreo());
    }
}
