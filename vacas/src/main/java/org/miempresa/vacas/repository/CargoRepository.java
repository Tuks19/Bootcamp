package org.miempresa.vacas.repository;

import org.miempresa.vacas.models.Cargo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Integer>{

}
