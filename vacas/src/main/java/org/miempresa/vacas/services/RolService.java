
package org.miempresa.vacas.services;

import lombok.RequiredArgsConstructor;
import org.miempresa.vacas.models.Rol;
import org.miempresa.vacas.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolService {

    private final RolRepository rolRepository;

    public List<Rol> listarTodosRoles() {
        return rolRepository.findAll();
    }

    public Rol obtenerPorId(Integer id) {
        return rolRepository.findById(id).orElse(null);
    }
}

