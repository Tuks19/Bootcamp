package org.miempresa.vacas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.miempresa.vacas.models.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNombre(String nombre);
    List<Usuario> findByNombreIgnoreCaseContaining(String nombre);

    @Query("SELECT u FROM Usuario u WHERE u.equipo.id_equipo = :id_equipo")
    List<Usuario> findUsuariosPorEquipo(@Param("id_equipo") Integer id_equipo);

    Usuario getUsuarioByNroCedula(Integer nroCedula);

    boolean existsUsuarioByNroCedula(Integer nroCedula);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.nombre = :nombre, u.apellido = :apellido, u.correo = :correo WHERE u.idUsuario = :id")
    void actualizarUsuario(@Param("id") Integer id,
                           @Param("nombre") String nombre,
                           @Param("apellido") String apellido,
                           @Param("correo") String correo);
}

