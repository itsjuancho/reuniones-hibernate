package com.juancho.dao;

import com.juancho.domain.Reunion;
import jakarta.persistence.Query;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ReunionDAO extends AbstractDAO<Reunion> {
    public ReunionDAO() {
        super.setCurrentClass(Reunion.class);
    }

//    public Reunion proximaReunion() {
//        String queryString = "FROM " + Reunion.class.getName() + " WHERE fecha > NOW() ORDER BY fecha";
//        Query query = getEntity().createQuery(queryString).setMaxResults(1);
//        return (Reunion) query.getSingleResult();
//    }
//
//    public List<Reunion> obtenerReunionesDiaSiguiente() {
//        String queryString = "FROM " + Reunion.class.getName() + " WHERE fecha BETWEEN ?1 AND ?2";
//        Query query = getEntity().createQuery(queryString);
//        LocalDate diaSiguiente = LocalDate.now().plus(1, ChronoUnit.DAYS);
//        query.setParameter(1, diaSiguiente.atStartOfDay());
//        query.setParameter(2, diaSiguiente.plus(1, ChronoUnit.DAYS).atStartOfDay());
//        return query.getResultList();
//    }
}
