package com.backend.clasesya.repository;

import com.backend.clasesya.entity.Horario;
import com.backend.clasesya.entity.Profesor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import javax.sound.sampled.Port;
import java.time.DayOfWeek;
import java.util.List;

import static com.backend.clasesya.fixtures.HorarioTestData.crearHorarioTest;
import static com.backend.clasesya.fixtures.ProfesorTestaData.crearProfesorTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class HorarioRepositoryTests {

    @Autowired
    private IHorarioRepository repositoryHorario;
    @Autowired
    private IProfesorRepository repositoryProfesor;

    @Test
    public void findByProfesor_sinHorario_retornaListVacio() {
        Profesor profesor = repositoryProfesor.save(crearProfesorTest());

        List<Horario> horarios = repositoryHorario.findByProfesorId(profesor.getId());

        Assertions.assertTrue(horarios.isEmpty());
    }

    @Test
    public void findByProfesor_retornaHorariosDelProfesor() {
        Profesor profesor1 = repositoryProfesor.save(crearProfesorTest());
        Profesor profesor2 = repositoryProfesor.save(crearProfesorTest());

        repositoryHorario.save(crearHorarioTest(profesor1, DayOfWeek.MONDAY));
        repositoryHorario.save(crearHorarioTest(profesor1, DayOfWeek.FRIDAY));
        repositoryHorario.save(crearHorarioTest(profesor2, DayOfWeek.FRIDAY));

        List<Horario> horarios = repositoryHorario.findByProfesorId(profesor1.getId());

        Assertions.assertEquals(2, horarios.size());
        Assertions.assertTrue(
                horarios.stream().allMatch(h -> h.getProfesor().getId().equals(profesor1.getId()))
        );
    }

    @Test
    public void findByProfesorIdAndDia_filtroPorDia() {
        Profesor profesor = repositoryProfesor.save(crearProfesorTest());

        repositoryHorario.save(crearHorarioTest(profesor, DayOfWeek.MONDAY));
        repositoryHorario.save(crearHorarioTest(profesor, DayOfWeek.FRIDAY));

        List<Horario> horarioViernes = repositoryHorario.findByProfesorIdAndDiaDisponible(
                profesor.getId(), DayOfWeek.FRIDAY
        );

        Assertions.assertEquals(1, horarioViernes.size());
        Assertions.assertEquals(DayOfWeek.FRIDAY, horarioViernes.get(0).getDiaDisponible());
    }

    @Test
    public void findByProfesorIdAndDia_filtroPorDia_sinHorario() {
        Profesor profesor = repositoryProfesor.save(crearProfesorTest());

        repositoryHorario.save(crearHorarioTest(profesor, DayOfWeek.MONDAY));

        List<Horario> horarios = repositoryHorario.findByProfesorIdAndDiaDisponible(
                profesor.getId(), DayOfWeek.FRIDAY
        );

        Assertions.assertTrue(horarios.isEmpty());
    }

}
