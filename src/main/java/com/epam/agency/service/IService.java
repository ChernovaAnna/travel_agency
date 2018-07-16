package com.epam.agency.service;

import com.epam.agency.domain.Identifier;

import java.util.List;

public interface IService <T extends Identifier> {
    void create(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> findAll();
    T findById(int id);
}
