package com.epam.agency.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Stores information about clients.
 * Implements the Identifier interface.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@NamedQueries({
        @NamedQuery(name = Client.FIND_CLIENT_BY_ID, query = "FROM Client c WHERE c.id=:id"),
        @NamedQuery(name = Client.DELETE_CLIENT, query = "DELETE FROM Client c WHERE c.id=:id")
})
public class Client implements Identifier {
    public final static String FIND_CLIENT_BY_ID = "findClientById";
    public final static String DELETE_CLIENT = "deleteClient";
    /**
     * List of tours visited by the client
     */
    @ManyToMany(mappedBy = "clients")
    List<Tour> tours;
    /**
     * List of reviews wrote by the client
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.ALL)
    List<Review> reviews;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
     * Client's login
     */
    @Column(name = "login")
    @NonNull
    private String login;
    /**
     * Client's password
     */
    @Column(name = "password")
    @NonNull
    private String password;
    /**
     * Unique id of the client
     */

}
