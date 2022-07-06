package com.juancho.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sala")
public class Sala {

    @Id
    @Column(length = 20)
    private String id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "capacidad")
    private Integer capacidad;

    @OneToMany(mappedBy = "sala")
    private List<Reunion> reuniones;

    public Sala() {
    }

    public Sala(String id, String descripcion, Integer capacidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public List<Reunion> getReuniones() {
        return reuniones;
    }

    public void setReuniones(List<Reunion> reuniones) {
        this.reuniones = reuniones;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
