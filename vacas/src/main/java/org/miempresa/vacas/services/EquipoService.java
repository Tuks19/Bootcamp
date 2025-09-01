package org.miempresa.vacas.services;

import lombok.RequiredArgsConstructor;
import org.miempresa.vacas.models.Equipo;
import org.miempresa.vacas.repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public List<Equipo> listarTodosEquipos() {
        return equipoRepository.findAll();
    }

    public Equipo obtenerPorId(Integer id) {
        return equipoRepository.findById(id).orElse(null);
    }
}
