package com.backend.clasesya.controller;

import com.backend.clasesya.dto.horario.HorarioCreateDTO;
import com.backend.clasesya.dto.horario.HorarioResponseDTO;
import com.backend.clasesya.service.IHorarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/profesor/{profesorId}/horario")
public class HorarioController {
    private final IHorarioService service;

    public HorarioController(IHorarioService service) {
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
}
