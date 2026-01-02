package com.backend.clasesya.dto.horario;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class HorarioUpdateDTO {

    private DayOfWeek diaDisponible;
    private LocalTime horaInicio;
    private LocalTime horaFin;


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
