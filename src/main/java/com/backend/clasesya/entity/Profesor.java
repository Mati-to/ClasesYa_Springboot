package com.backend.clasesya.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Profesor extends Usuario {

    @Column(nullable = false)
    private String profesion;

    @ManyToMany
    @JoinTable(
            name = "profesor_area",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id")
    )
    private List<Area> areas;


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
