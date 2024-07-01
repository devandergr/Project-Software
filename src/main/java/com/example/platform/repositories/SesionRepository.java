package com.example.platform.repositories;

import com.example.platform.models.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SesionRepository extends JpaRepository<Sesion, Long> {
    List<Sesion> findUserById(Long user);
}
