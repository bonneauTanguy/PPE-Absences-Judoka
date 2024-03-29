package com.example.abscence_judoka.DAO;

public abstract class DAO<T> {
    public abstract void insert(T obj);

    public abstract void update(T obj);

    public abstract void delete(T obj);
}
