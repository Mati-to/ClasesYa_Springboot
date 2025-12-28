package com.backend.clasesya.service;

import com.backend.clasesya.dto.alumno.AlumnoCreateDTO;
import com.backend.clasesya.dto.alumno.AlumnoResponseDTO;
import com.backend.clasesya.dto.alumno.AlumnoUpdateDTO;

import java.util.List;

public interface IAlumnoService {

    List<AlumnoResponseDTO> findAll();

    AlumnoResponseDTO findById(Long id);

    AlumnoResponseDTO save(AlumnoCreateDTO alumnoDto);

    AlumnoResponseDTO update(AlumnoUpdateDTO alumnoDto, Long id);

    void deleteById(Long id);

}
