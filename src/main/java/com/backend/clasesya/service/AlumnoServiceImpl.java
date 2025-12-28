package com.backend.clasesya.service;

import com.backend.clasesya.dto.alumno.AlumnoCreateDTO;
import com.backend.clasesya.dto.alumno.AlumnoResponseDTO;
import com.backend.clasesya.dto.alumno.AlumnoUpdateDTO;
import com.backend.clasesya.entity.Alumno;
import com.backend.clasesya.exception.NotFoundException;
import com.backend.clasesya.mapper.AlumnoMapper;
import com.backend.clasesya.repository.IAlumnoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlumnoServiceImpl implements IAlumnoService {
    private final IAlumnoRepository repository;
    private final AlumnoMapper mapper;

    public AlumnoServiceImpl(IAlumnoRepository repository, AlumnoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    @Transactional(readOnly = true)
    public List<AlumnoResponseDTO> findAll() {
        List<Alumno> alumnos = repository.findAll();

        return alumnos.stream()
                .map(mapper::toAlumnoDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public AlumnoResponseDTO findById(Long id) {
        Alumno alumno = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Alumno", id));
        return mapper.toAlumnoDto(alumno);
    }

    @Override
    @Transactional
    public AlumnoResponseDTO save(AlumnoCreateDTO alumnoDto) {
        Alumno alumno = mapper.toAlumno(alumnoDto);
        repository.save(alumno);
        return mapper.toAlumnoDto(alumno);
    }

    @Override
    @Transactional
    public AlumnoResponseDTO update(AlumnoUpdateDTO alumnoDto, Long id) {
        Alumno alumno = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Alumno", id));
        mapper.toUpdateAlumno(alumno, alumnoDto);
        return mapper.toAlumnoDto(alumno);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Alumno alumno = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Alumno", id));
        repository.deleteById(alumno.getId());
    }
}
