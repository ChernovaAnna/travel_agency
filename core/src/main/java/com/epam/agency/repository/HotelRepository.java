package com.epam.agency.repository;

import com.epam.agency.domain.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Generic interface provide CRUD methods
 * for concrete repository realizations.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

@Repository("hotelRepository")
public interface HotelRepository extends CrudRepository<Hotel, Long> {
}
