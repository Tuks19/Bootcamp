package org.miempresa.vacas.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "nro_cedula", nullable = false, unique = true)
    private Integer nroCedula;

    @Column(name = "correo")
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "dias_vacaciones")
    @Builder.Default
    private Integer diasVacaciones = 0;

    @Column(name = "estado")
    @Builder.Default
    private Boolean estado = true;

    @Column(name = "contrasena", nullable = false)
    @Builder.Default
    private String contrasena = "default_password";

    @Column(name = "telefono", length = 255)
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "dias_vacaciones_restante")
    @Builder.Default
    private Integer diasVacacionesRestante = 0;

    @Column(name = "requiere_cambio_contrasena")
    private Boolean requiereCambioContrasena;

    public Integer getEdad() {
        if (fechaNacimiento == null) return null;
        return java.time.Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public Integer getAntiguedadEnAnios() {
        if (fechaIngreso == null) return 0;
        return java.time.Period.between(fechaIngreso, LocalDate.now()).getYears();
    }

    public Usuario(String nombre, String apellido, Integer nroCedula,
                   String correo, Rol rol, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroCedula = nroCedula;
        this.correo = correo;
        this.rol = rol;
        this.fechaIngreso = fechaIngreso;
    }
}
