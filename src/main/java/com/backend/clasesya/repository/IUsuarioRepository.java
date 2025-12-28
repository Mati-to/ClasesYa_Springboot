package com.backend.clasesya.repository;

import com.backend.clasesya.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
