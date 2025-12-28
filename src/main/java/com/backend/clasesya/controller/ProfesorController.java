package com.backend.clasesya.controller;

import com.backend.clasesya.dto.profesor.ProfesorCreateDTO;
import com.backend.clasesya.dto.profesor.ProfesorResponseDTO;
import com.backend.clasesya.dto.profesor.ProfesorUpdateDTO;
import com.backend.clasesya.service.IProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {
    private final IProfesorService service;

    public ProfesorController(IProfesorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProfesorResponseDTO>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorResponseDTO> details(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProfesorResponseDTO> create(@RequestBody ProfesorCreateDTO profesorDto) {
        ProfesorResponseDTO response = service.save(profesorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorResponseDTO> update(
            @RequestBody ProfesorUpdateDTO profesorDto,
            @PathVariable Long id)
    {
        ProfesorResponseDTO response = service.update(profesorDto, id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
