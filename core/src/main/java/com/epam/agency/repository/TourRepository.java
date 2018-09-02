package com.epam.agency.repository;

import com.epam.agency.domain.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Generic interface provide CRUD methods
 * for concrete repository realizations.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

@Repository("tourRepository")
public interface TourRepository extends CrudRepository<Tour, Long> {
}