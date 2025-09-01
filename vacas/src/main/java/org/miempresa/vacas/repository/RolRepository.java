package org.miempresa.vacas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.miempresa.vacas.models.Rol;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    List<Rol> findById(int id);
}
