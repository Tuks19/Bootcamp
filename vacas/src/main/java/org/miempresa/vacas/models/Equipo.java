package org.miempresa.vacas.models;

import lombok.*;
import jakarta.persistence.*;


@Entity
@Table (name = "equipos", schema = "public")
@Getter
@Setter
@Builder
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_equipo")
    private Integer id_equipo;

    @Column (name = "nombre", nullable = false)
    private String nombre;

    public Equipo(){}

    public Equipo(Integer id_equipo, String nombre) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
    }

    public Equipo( String nombre){
        this.nombre = nombre;
    }
}
