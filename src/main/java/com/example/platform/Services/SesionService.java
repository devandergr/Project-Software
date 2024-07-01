package com.example.platform.Services;

import com.example.platform.models.Sesion;
import com.example.platform.repositories.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionService {

    @Autowired
    private SesionRepository sesionRepository;

    public Sesion crearSesion(Sesion sesion) {
        return sesionRepository.save(sesion);
    }

    public List<Sesion> obtenerSesionesPorUsuarioId(Long usuarioId) {
        return sesionRepository.findByUsuarioId(usuarioId);
    }

    public void eliminarSesion(Long sesionId) {
        sesionRepository.deleteById(sesionId);
    }
}