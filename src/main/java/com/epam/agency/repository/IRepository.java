package com.epam.agency.repository;

import com.epam.agency.domain.Identifier;

import java.util.List;

public interface IRepository <T extends Identifier> {
    void create(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> findAll();
    T findById(int id);

}
