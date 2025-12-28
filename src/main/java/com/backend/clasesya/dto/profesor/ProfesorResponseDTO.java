package com.backend.clasesya.dto.profesor;

import com.backend.clasesya.dto.UsuarioResponseDTO;

import java.time.LocalDate;

public class ProfesorResponseDTO extends UsuarioResponseDTO {

    private String profesion;

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}
