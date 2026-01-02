package com.backend.clasesya.repository;

import com.backend.clasesya.entity.Alumno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;
import java.util.UUID;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AlumnoRepositoryTests {

    @Autowired
    private IAlumnoRepository repository;


    @Test
    public void noPermitirCorreoDuplicado() {
        Alumno alumno1 = repository.save(crearAlumno());
        Alumno alumno2 = repository.save(crearAlumno());

        alumno1.setCorreo("correo@correo.cl");
        alumno2.setCorreo("correo@correo.cl");

        Assertions.assertThrows(
                DataIntegrityViolationException.class,
                () -> repository.saveAndFlush(alumno2)
        );
    }

    // Testear sobre clases y reseñas.



    public Alumno crearAlumno() {
        Alumno alumno = new Alumno();
        alumno.setNombre("Alumno prueba");
        alumno.setCorreo(UUID.randomUUID() + "@correo.cl");
        alumno.setContrasena("12345");
        alumno.setFechaRegistro(LocalDate.now());
        return alumno;
    }
}
