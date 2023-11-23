package org.examen;

import java.time.LocalDate;

public class Piloto {
    private String id;
    private String codigo;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String url;
    private Constructor equipo;

    public Piloto(String id, String codigo, String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String url, Constructor equipo) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.url = url;
        this.equipo = equipo;
    }

    public Piloto(String codigo, String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String url, Constructor equipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.url = url;
        this.equipo = equipo;
    }


    public String getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getUrl() {
        return url;
    }

    public Constructor getEquipo() {
        return equipo;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", url='" + url + '\'' +
                ", equipo=" + equipo +
                '}';
    }
}
