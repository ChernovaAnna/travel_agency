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
public class Client implements Identifier {

    /**
     * Unique id of the client
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

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
     * List of tours visited by the client
     */
    @ManyToMany(mappedBy = "clients")
    List<Tour> tours;

    /**
     * List of reviews wrote by the client
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client_id", cascade = CascadeType.ALL)
    List<Review> reviews;
}
