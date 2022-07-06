package com.juancho;

import com.juancho.dao.ActaDAO;
import com.juancho.dao.ReunionDAO;
import com.juancho.dao.SalaDAO;
import com.juancho.domain.Acta;
import com.juancho.domain.Reunion;
import com.juancho.domain.Sala;
import jakarta.persistence.NoResultException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ReunionDAO dao = new ReunionDAO();
        List<Reunion> reuniones = dao.getAll();
        for (Reunion reunion : reuniones) {
            System.out.println(reunion);
        }

//        Reunion nuevaReunion = new Reunion(new Date(), "Reunión de prueba");
//        System.out.println(nuevaReunion);
//        dao.save(nuevaReunion);
//        System.out.println(nuevaReunion);
        Reunion reunionProxima = new Reunion(LocalDateTime.now().plus(2, ChronoUnit.DAYS), "Reunión de pruebas");
        System.out.println(reunionProxima);
        dao.save(reunionProxima);

        ActaDAO actaDAO = new ActaDAO();
        Acta acta1 = new Acta("Reunión anulada", reunionProxima);
        actaDAO.save(acta1);
        System.out.println("Acta guardada...");

//        try {
//            System.out.println("Tu próxima reunión es: " + dao.proximaReunion().getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
//        } catch (NoResultException e) {
//            System.out.println("No tienes ninguna reunión próxima...");
//        }

//        List<Reunion> reunionesDiaSiguiente = dao.obtenerReunionesDiaSiguiente();
//        if (reunionesDiaSiguiente.size() == 0) {
//            System.out.println("No hay reuniones para el día de mañana...");
//        } else {
//            for (Reunion reunion : reunionesDiaSiguiente) {
//                System.out.println(reunion);
//            }
//        }

        SalaDAO salaDAO = new SalaDAO();
        Sala s1 = new Sala("S017", "Sala de reuniones generales", 36);
        Sala s2 = new Sala("S066", "Sala de Presidencia", 15);
        salaDAO.save(s1);
        System.out.println("Paso 1: " + salaDAO.getAll());
        salaDAO.save(s2);

        System.out.println(s1);
        s1.setDescripcion("Sala de reuniones principales");
        salaDAO.update(s1);
        System.out.println("Paso 2: " +salaDAO.getAll());
        salaDAO.delete(s2);
        System.out.println("Paso 3: " +salaDAO.getAll());
        reunionProxima.setSala(s1);
        dao.update(reunionProxima);
    }
}
