package com.backend.clasesya.service;

import com.backend.clasesya.dto.profesor.ProfesorCreateDTO;
import com.backend.clasesya.dto.profesor.ProfesorResponseDTO;
import com.backend.clasesya.dto.profesor.ProfesorUpdateDTO;
import com.backend.clasesya.entity.Profesor;
import com.backend.clasesya.exception.NotFoundException;
import com.backend.clasesya.mapper.ProfesorMapper;
import com.backend.clasesya.repository.IProfesorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfesorServiceImpl implements IProfesorService {
    private final IProfesorRepository repository;
    private final ProfesorMapper mapper;

    public ProfesorServiceImpl(IProfesorRepository profesorRepository, ProfesorMapper profesorMapper){
        this.repository = profesorRepository;
        this.mapper = profesorMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfesorResponseDTO> findAll() {
        List<Profesor> profesores = repository.findAll();

        return profesores.stream()
                .map(mapper::toProfesorDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProfesorResponseDTO findById(Long id) {
        Profesor profesor = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Profesor", id));

        return mapper.toProfesorDto(profesor);
    }

    @Override
    @Transactional
    public ProfesorResponseDTO save(ProfesorCreateDTO profesorDto) {
        Profesor profesor = mapper.toProfesor(profesorDto);
        repository.save(profesor);
        return mapper.toProfesorDto(profesor);
    }

    @Override
    @Transactional
    public ProfesorResponseDTO update(ProfesorUpdateDTO profesorDto, Long id) {
        Profesor profesor = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Profesor", id));
        mapper.toUpdateProfesor(profesor, profesorDto);
        return mapper.toProfesorDto(profesor);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Profesor profesor = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Profesor", id));
        repository.deleteById(profesor.getId());
    }
}
