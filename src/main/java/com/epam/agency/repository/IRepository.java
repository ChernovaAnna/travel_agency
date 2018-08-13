package com.epam.agency.repository;

import com.epam.agency.domain.Identifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Generic interface provide CRUD methods
 * for concrete repository realizations.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

@Repository
public interface IRepository <T extends Identifier> {
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
    T findById(Long id);

}
