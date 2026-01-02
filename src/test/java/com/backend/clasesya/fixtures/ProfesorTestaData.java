package com.backend.clasesya.fixtures;

import com.backend.clasesya.entity.Profesor;

import java.time.LocalDate;
import java.util.UUID;

public class ProfesorTestaData {

    public static Profesor crearProfesorTest() {
        Profesor profesor = new Profesor();
        profesor.setNombre("Profesor Prueba");
        profesor.setCorreo(UUID.randomUUID() + "@correo.cl");
        profesor.setContrasena("12345");
        profesor.setFechaRegistro(LocalDate.now());
        profesor.setProfesion("Ingeniero en Computación");
        return profesor;
    }

}
