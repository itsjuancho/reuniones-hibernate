package com.juancho.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "reunion")
public class Reunion {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "asunto")
    private String asunto;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sala sala;

    @OneToOne(mappedBy = "reunion")
    private Acta acta;

    public Reunion() {

    }

    public Reunion(LocalDateTime fecha, String asunto) {
        this.fecha = fecha;
        this.asunto = asunto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Acta getActa() {
        return acta;
    }

    public void setActa(Acta acta) {
        this.acta = acta;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Reunion{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", asunto='" + asunto + '\'' +
                '}';
    }
}
