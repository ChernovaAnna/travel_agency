package com.epam.agency.repository;

import com.epam.agency.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Generic interface provide CRUD methods
 * for concrete repository realizations.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

@Repository("clientRepository")
@Transactional
public interface ClientRepository extends CrudRepository<Client, Long> {

    Optional<Client> findByLogin(String login);

    Optional<Client> findByLoginAndPassword(String login, String password);
}
