package com.backend.clasesya.mapper;

import com.backend.clasesya.dto.horario.HorarioConProfesorDTO;
import com.backend.clasesya.dto.horario.HorarioCreateDTO;
import com.backend.clasesya.dto.horario.HorarioResponseDTO;
import com.backend.clasesya.dto.horario.HorarioUpdateDTO;
import com.backend.clasesya.entity.Horario;
import org.springframework.stereotype.Component;

@Component
public class HorarioMapper {
    private final ProfesorMapper profesorMapper;

    public HorarioMapper(ProfesorMapper profesorMapper) {
        this.profesorMapper = profesorMapper;
    }

    public Horario toHorario(HorarioCreateDTO dto) {
        Horario horario = new Horario();
        horario.setDiaDisponible(dto.getDiaDisponible());
        horario.setHoraInicio(dto.getHoraInicio());
        horario.setHoraFin(dto.getHoraFin());
        return horario;
    }

    public HorarioResponseDTO toHorarioDto(Horario horario) {
        HorarioResponseDTO dto = new HorarioResponseDTO();
        dto.setId(horario.getId());
        dto.setDiaDisponible(horario.getDiaDisponible());
        dto.setHoraInicio(horario.getHoraInicio());
        dto.setHoraFin(horario.getHoraFin());
        return dto;
    }

    public HorarioConProfesorDTO toHorarioConProfesorDTO(Horario horario) {
        HorarioConProfesorDTO dto = new HorarioConProfesorDTO();
        dto.setProfesor(profesorMapper.toProfesorHorarioDto(horario.getProfesor()));
        dto.setDiaDisponible(horario.getDiaDisponible());
        dto.setHoraInicio(horario.getHoraInicio());
        dto.setHoraFin(horario.getHoraFin());
        return dto;
    }

    public void toUpdateHorario(Horario horario, HorarioUpdateDTO dto) {
        horario.setDiaDisponible(dto.getDiaDisponible());
        horario.setHoraInicio(dto.getHoraInicio());
        horario.setHoraFin(dto.getHoraFin());
    }

}
