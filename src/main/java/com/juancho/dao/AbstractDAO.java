package com.juancho.dao;

import com.juancho.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public abstract class AbstractDAO<T> implements DAO<T> {
    private EntityManager entity = EntityManagerUtil.getEntityManager();
    private Class<T> currentClass;

    @Override
    public Optional<T> get(Long id) {
        return Optional.ofNullable(entity.find(currentClass, id));
    }

    @Override
    public List<T> getAll() {
        String queryString = "FROM " + currentClass.getName();
        Query query = entity.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public void save(T t) {
        this.executeInsideTransaction(entity -> entity.persist(t));
    }

    @Override
    public void update(T t) {
        this.executeInsideTransaction(entity -> entity.merge(t));
    }

    @Override
    public void delete(T t) {
        this.executeInsideTransaction(entity -> entity.remove(t));
    }

    public void setCurrentClass(Class<T> currentClass) {
        this.currentClass = currentClass;
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entity.getTransaction();
        try {
            tx.begin();
            action.accept(entity);
            tx.commit();
        } catch (RuntimeException error) {
            tx.rollback();
            throw error;
        }
    }

    public EntityManager getEntity() {
        return entity;
    }
}
