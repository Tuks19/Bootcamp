package org.miempresa.vacas.models;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table (name = "cargos" , schema = "public")
@Getter
@Setter
@Builder
public class Cargo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_cargo")
    private Integer id_cargo;

    @Column (name = "nombre", nullable = false, length = 255)
    private String nombre;

    public Cargo(){};

    public Cargo(Integer id_cargo, String nombre){
        this.id_cargo = id_cargo;
        this.nombre = nombre;
    }

    public Cargo(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return "Cargo{" + "id_cargo=" + id_cargo + ", nombre=" + nombre + '}';
    }
}
