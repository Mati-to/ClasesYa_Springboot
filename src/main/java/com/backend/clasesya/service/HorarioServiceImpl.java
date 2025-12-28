package com.backend.clasesya.service;

import com.backend.clasesya.dto.horario.HorarioCreateDTO;
import com.backend.clasesya.dto.horario.HorarioResponseDTO;
import com.backend.clasesya.entity.Horario;
import com.backend.clasesya.entity.Profesor;
import com.backend.clasesya.exception.BusinessException;
import com.backend.clasesya.exception.NotFoundException;
import com.backend.clasesya.mapper.HorarioMapper;
import com.backend.clasesya.repository.IHorarioRepository;
import com.backend.clasesya.repository.IProfesorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HorarioServiceImpl implements IHorarioService {
    private final IHorarioRepository repositoryHorario;
    private final IProfesorRepository repositoryProfesor;
    private final HorarioMapper mapper;

    public HorarioServiceImpl(IHorarioRepository repositoryHorario,
                              IProfesorRepository profesorRepository,
                              HorarioMapper mapper
    ) {
        this.repositoryHorario = repositoryHorario;
        this.repositoryProfesor = profesorRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<HorarioResponseDTO> findAll() {
        List<Horario> horarios = repositoryHorario.findAll();

        return horarios.stream()
                .map(mapper::toHorarioDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<HorarioResponseDTO> findAllByProfesor(Long profesorId) {
        Profesor profesor = repositoryProfesor.findById(profesorId)
                .orElseThrow(() -> new NotFoundException("Profesor", profesorId));

        List<Horario> horarios = repositoryHorario.findByProfesorId(profesorId);
        return horarios.stream()
                .map(mapper::toHorarioDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public HorarioResponseDTO findById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public HorarioResponseDTO create(HorarioCreateDTO horarioDto, Long profesorId) {
        Profesor profesor = repositoryProfesor.findById(profesorId)
                .orElseThrow(() -> new NotFoundException("Profesor", profesorId));

        validarChoqueHorario(horarioDto, profesorId);

        Horario horario = mapper.toHorario(horarioDto);
        horario.setProfesor(profesor);
        repositoryHorario.save(horario);
        return mapper.toHorarioDto(horario);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {

    }


    private void validarChoqueHorario(HorarioCreateDTO dto, Long profesorId) {
        if (!dto.getHoraInicio().isBefore(dto.getHoraFin())) {
            throw new BusinessException("La hora de inicio debe ser antes de la hora de su término.");
        }

        List<Horario> horarios = repositoryHorario.findByProfesorIdAndDiaDisponible(profesorId, dto.getDiaDisponible());

        for (Horario h : horarios) {
            boolean seChocan = dto.getHoraInicio().isBefore(h.getHoraFin()) &&
                    dto.getHoraFin().isAfter(h.getHoraInicio()
            );

            if (seChocan) {
                throw new BusinessException("El horario choca con otro ya existente: " +
                        h.getHoraInicio() + " - " + h.getHoraFin()
                );
            }
        }
    }

}
