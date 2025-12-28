package com.backend.clasesya.mapper;

import com.backend.clasesya.dto.horario.HorarioCreateDTO;
import com.backend.clasesya.dto.horario.HorarioResponseDTO;
import com.backend.clasesya.entity.Horario;
import org.springframework.stereotype.Component;

@Component
public class HorarioMapper {

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


}
