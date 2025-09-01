package org.miempresa.vacas.services;

import lombok.RequiredArgsConstructor;
import org.miempresa.vacas.models.Cargo;
import org.miempresa.vacas.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;

    public List<Cargo> listarTodosCargos() {
        return cargoRepository.findAll();
    }

    public Cargo obtenerPorId(Integer id) {
        return cargoRepository.findById(id).orElse(null);
    }
}
