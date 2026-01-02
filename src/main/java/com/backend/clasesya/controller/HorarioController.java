package com.backend.clasesya.controller;

import com.backend.clasesya.dto.horario.HorarioConProfesorDTO;
import com.backend.clasesya.service.IHorarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {
    private final IHorarioService service;

    public HorarioController(IHorarioService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<HorarioConProfesorDTO>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

}
