package com.backend.clasesya.dto.horario;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class HorarioResponseDTO {

    private Long id;
    private DayOfWeek diaDisponible;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDiaDisponible() {
        return diaDisponible;
    }

    public void setDiaDisponible(DayOfWeek diaDisponible) {
        this.diaDisponible = diaDisponible;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}
