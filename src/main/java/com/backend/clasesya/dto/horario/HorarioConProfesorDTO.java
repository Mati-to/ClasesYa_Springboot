package com.backend.clasesya.dto.horario;

import com.backend.clasesya.dto.profesor.ProfesorResumenResponseDTO;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class HorarioConProfesorDTO {

    private ProfesorResumenResponseDTO profesor;
    private DayOfWeek diaDisponible;
    private LocalTime horaInicio;
    private LocalTime horaFin;


    public ProfesorResumenResponseDTO getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorResumenResponseDTO profesor) {
        this.profesor = profesor;
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
