package com.backend.clasesya.controller;

import com.backend.clasesya.dto.alumno.AlumnoCreateDTO;
import com.backend.clasesya.dto.alumno.AlumnoResponseDTO;
import com.backend.clasesya.dto.alumno.AlumnoUpdateDTO;
import com.backend.clasesya.service.IAlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
    private final IAlumnoService service;

    public AlumnoController(IAlumnoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AlumnoResponseDTO>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseDTO> details(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<AlumnoResponseDTO> create(@RequestBody AlumnoCreateDTO alumnoDto) {
        AlumnoResponseDTO response = service.save(alumnoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseDTO> update(@RequestBody AlumnoUpdateDTO alumnoDto, @PathVariable Long id) {
        AlumnoResponseDTO response = service.update(alumnoDto, id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
