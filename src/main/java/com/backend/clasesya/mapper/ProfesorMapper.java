package com.backend.clasesya.mapper;

import com.backend.clasesya.dto.profesor.ProfesorCreateDTO;
import com.backend.clasesya.dto.profesor.ProfesorResumenResponseDTO;
import com.backend.clasesya.dto.profesor.ProfesorResponseDTO;
import com.backend.clasesya.dto.profesor.ProfesorUpdateDTO;
import com.backend.clasesya.entity.Profesor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ProfesorMapper {

    public Profesor toProfesor(ProfesorCreateDTO dto) {
        Profesor profesor = new Profesor();
        profesor.setNombre(dto.getNombre());
        profesor.setCorreo(dto.getCorreo());
        profesor.setContrasena(dto.getContrasena());
        profesor.setProfesion(dto.getProfesion());
        profesor.setFechaRegistro(LocalDate.now());
        return profesor;
    }

    public ProfesorResponseDTO toProfesorDto(Profesor profesor) {
        ProfesorResponseDTO dto = new ProfesorResponseDTO();
        dto.setId(profesor.getId());
        dto.setNombre(profesor.getNombre());
        dto.setCorreo(profesor.getCorreo());
        dto.setProfesion(profesor.getProfesion());
        dto.setFechaRegistro(profesor.getFechaRegistro());
        return dto;
    }

    public ProfesorResumenResponseDTO toProfesorHorarioDto(Profesor profesor) {
        ProfesorResumenResponseDTO dto = new ProfesorResumenResponseDTO();
        dto.setNombre(profesor.getNombre());
        dto.setProfesion(profesor.getProfesion());
        dto.setAreas(profesor.getAreas());
        return dto;
    }

    public void toUpdateProfesor(Profesor profesor, ProfesorUpdateDTO dto) {
        profesor.setNombre(dto.getNombre());
        profesor.setCorreo(dto.getCorreo());
        profesor.setProfesion(dto.getProfesion());
    }

}
