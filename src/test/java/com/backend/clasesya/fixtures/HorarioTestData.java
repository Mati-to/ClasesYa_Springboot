package com.backend.clasesya.fixtures;

import com.backend.clasesya.entity.Horario;
import com.backend.clasesya.entity.Profesor;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Random;

public class HorarioTestData {

    public static Horario crearHorarioTest(Profesor profesor, DayOfWeek dia) {
        Horario horario = new Horario();
        Random rand = new Random();
        horario.setProfesor(profesor);
        horario.setDiaDisponible(dia);
        horario.setHoraInicio(LocalTime.now());
        horario.setHoraFin(horario.getHoraInicio().plusHours(1));
        return horario;
    }

}
