package com.backend.clasesya.service;

import com.backend.clasesya.dto.horario.HorarioCreateDTO;
import com.backend.clasesya.dto.horario.HorarioResponseDTO;

import java.util.List;

public interface IHorarioService {

    List<HorarioResponseDTO> findAll();
    List<HorarioResponseDTO> findAllByProfesor(Long profesorId);
    HorarioResponseDTO findById(Long id);
    HorarioResponseDTO create(HorarioCreateDTO horarioDto, Long profesorId);
    // Crear el update
    void deleteById(Long id);

}
