package com.backend.clasesya.repository;

import com.backend.clasesya.entity.Horario;
import com.backend.clasesya.entity.Profesor;
import com.backend.clasesya.fixtures.ProfesorTestaData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static com.backend.clasesya.fixtures.ProfesorTestaData.crearProfesorTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProfesorRepositoryTests {

    @Autowired
    private IProfesorRepository repository;
    @Autowired
    private IHorarioRepository horarioRepository;

    @Test
    public void saveProfesor() {
        // Arrange
        Profesor profesor = crearProfesorTest();

        // Act
        Profesor profesorGuardado = repository.save(profesor);

        // Assert
        Assertions.assertNotNull(profesorGuardado.getId(),
                "El ID no debería ser null después del guardado"
        );
    }

    @Test
    public void findAllProfesores() {
        repository.save(crearProfesorTest());
        repository.save(crearProfesorTest());
        repository.save(crearProfesorTest());

        List<Profesor> profesores = repository.findAll();

        Assertions.assertEquals(3, profesores.size());
    }

    @Test
    public void findProfesorById() {
        Profesor profesor = repository.save(crearProfesorTest());

        Optional<Profesor> profesorEncontrado = repository.findById(profesor.getId());

        Assertions.assertTrue(profesorEncontrado.isPresent());
    }

    // ¿Debería hacer el testing de métodos del JpaRepo?

    @Test
    public void noPermitirCorreoDuplicado() {
        Profesor profesor1 = repository.save(crearProfesorTest());
        Profesor profesor2 = repository.save(crearProfesorTest());

        profesor1.setCorreo("correo@correo.cl");
        profesor2.setCorreo("correo@correo.cl");

        Assertions.assertThrows(
                DataIntegrityViolationException.class,
                () -> repository.saveAndFlush(profesor2)
        );
    }

    @Test
    public void noPermitirSinCorreo() {
        Profesor profesor = crearProfesorTest();

        profesor.setCorreo(null);

        Assertions.assertThrows(
                DataIntegrityViolationException.class,
                () -> repository.saveAndFlush(profesor)
        );
    }

    @Test
    public void profesorTieneHorario() {
        Profesor profesor = crearProfesorTest();
        Horario horario = new Horario();

        horario.setProfesor(profesor);
        horario.setDiaDisponible(DayOfWeek.FRIDAY);
        horario.setHoraInicio(LocalTime.of(10, 0));
        horario.setHoraFin(LocalTime.of(11, 0));
        horarioRepository.save(horario);

        Optional<Profesor> profesorConHorario = repository.findById(profesor.getId());

        // TERMINAR EL TESTING PARA OBTENER LOS HORARIOS DEL PROFESOR

        // Assertions.assertEquals(1, profesorConHorario.getHo);
    }
}
