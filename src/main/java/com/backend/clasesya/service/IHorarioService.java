package com.backend.clasesya.service;

import com.backend.clasesya.dto.horario.HorarioConProfesorDTO;
import com.backend.clasesya.dto.horario.HorarioCreateDTO;
import com.backend.clasesya.dto.horario.HorarioResponseDTO;
import com.backend.clasesya.dto.horario.HorarioUpdateDTO;

import java.util.List;

public interface IHorarioService {

    List<HorarioConProfesorDTO> findAll();
    List<HorarioResponseDTO> findAllByProfesor(Long profesorId);
    HorarioResponseDTO findById(Long id);
    HorarioResponseDTO create(HorarioCreateDTO horarioDto, Long profesorId);
    HorarioResponseDTO update(HorarioUpdateDTO horarioDto, Long id);
    void deleteById(Long id);

}
