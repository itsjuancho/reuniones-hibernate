package com.juancho.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "acta")
public class Acta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contenido")
    private String contenido;

    @OneToOne
    @JoinColumn(name = "reunion_id")
    private Reunion reunion;

    public Acta() {

    }

    public Acta(String contenido, Reunion reunion) {
        this.contenido = contenido;
        this.reunion = reunion;
        reunion.setActa(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    @Override
    public String toString() {
        return "Acta{" +
                "id=" + id +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}
