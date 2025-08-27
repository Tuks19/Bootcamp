package org.miempresa.demo1.models;

import java.io.Serializable;

public class Cliente implements Serializable {
    //Atributos Privados
    private int id;
    private String nombre;
    private String apellido;
    private String nro_cedula;
    private String telefono;

    //Constructor sin argumentos
    public Cliente(){}

    //Constructor sin id
    public Cliente(String nombre, String apellido, String nro_cedula, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nro_cedula = nro_cedula;
        this.telefono = telefono;
    }

    //Constructor Completo
    public Cliente(int id, String nombre, String apellido, String nro_cedula, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nro_cedula = nro_cedula;
        this.telefono = telefono;
    }

    //Setters y Getters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNro_cedula() {
        return nro_cedula;
    }
    public void setNro_cedula(String nro_cedula) {
        this.nro_cedula = nro_cedula;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //Metodos
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nroCedula='" + nro_cedula + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

}
