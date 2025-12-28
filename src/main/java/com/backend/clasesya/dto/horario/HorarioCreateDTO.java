package com.backend.clasesya.dto.horario;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class HorarioCreateDTO {

    private DayOfWeek diaDisponible;
    private LocalTime horaInicio;
    private LocalTime horaFin;


    public DayOfWeek getDiaDisponible() {
        return diaDisponible;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }
}
