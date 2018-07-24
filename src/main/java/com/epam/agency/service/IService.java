package com.epam.agency.service;

import com.epam.agency.domain.Identifier;

import java.util.List;

/**
 * Generic interface provide CRUD methods
 * for concrete service realizations.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

public interface IService <T extends Identifier> {
    /**
     * Create entity in the repository.
     *
     * @param entity
     */
    void create(T entity);

    /**
     * Update entity from the repository.
     *
     * @param entity
     */
    void update(T entity);

    /**
     * Delete entity from the repository
     *
     * @param entity
     */
    void delete(T entity);

    /**
     *
     * @return all entities from concrete repository
     */
    List<T> findAll();

    /**
     * Find entity by id in the repository
     *
     * @param id of entity
     * @return entity with corresponding id
     */
    T findById(int id);
}
