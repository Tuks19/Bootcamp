package org.miempresa.vacas.models;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table (name = "roles", schema = "public")
@Getter
@Setter
@Builder
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_rol")
    private Integer id_rol;

    private String nombre;

    public Rol(){};

    public Rol(Integer  id_rol, String nombre) {
        this.id_rol = id_rol;
        this.nombre = nombre;
    }
    public Rol(String nombre){
        this.nombre = nombre;
    }
}
