package com.backend.clasesya.service;

import com.backend.clasesya.dto.profesor.ProfesorCreateDTO;
import com.backend.clasesya.dto.profesor.ProfesorResponseDTO;
import com.backend.clasesya.dto.profesor.ProfesorUpdateDTO;

import java.util.List;

public interface IProfesorService {

    List<ProfesorResponseDTO> findAll();
    ProfesorResponseDTO findById(Long id);
    ProfesorResponseDTO save(ProfesorCreateDTO profesorDto);
    ProfesorResponseDTO update(ProfesorUpdateDTO profesorDto, Long id);
    void deleteById(Long id);

}
