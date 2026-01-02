package com.backend.clasesya.controller;

import com.backend.clasesya.dto.horario.HorarioCreateDTO;
import com.backend.clasesya.dto.horario.HorarioResponseDTO;
import com.backend.clasesya.dto.horario.HorarioUpdateDTO;
import com.backend.clasesya.service.IHorarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/profesor/{profesorId}/horario")
public class HorarioProfesorController {
    private final IHorarioService service;

    public HorarioProfesorController(IHorarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<HorarioResponseDTO>> listByProfesor(
            @PathVariable Long profesorId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllByProfesor(profesorId));
    }

    @PostMapping
    public ResponseEntity<HorarioResponseDTO> create(
            @RequestBody HorarioCreateDTO horarioDto,
            @PathVariable Long profesorId
    ) {
        HorarioResponseDTO response = service.create(horarioDto, profesorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{horarioId}")
    public ResponseEntity<HorarioResponseDTO> update(
            @RequestBody HorarioUpdateDTO horarioDto,
            @PathVariable Long horarioId
    ) {
        HorarioResponseDTO response = service.update(horarioDto, horarioId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{horarioId}")
    public ResponseEntity<Void> delete(@PathVariable Long horarioId) {
        service.deleteById(horarioId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
