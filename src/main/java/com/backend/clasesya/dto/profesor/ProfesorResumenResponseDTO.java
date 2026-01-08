package com.backend.clasesya.dto.profesor;

import com.backend.clasesya.entity.Area;

import java.util.List;

public class ProfesorResumenResponseDTO {

    private String nombre;
    private String profesion;
    private List<Area> areas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
