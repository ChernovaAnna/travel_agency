package com.epam.agency.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.dom4j.tree.AbstractEntity;

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
public class Client extends AbstractEntity {

    /**
     * List of reviews wrote by the client
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * List of tours visited by the client
     */
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "client_tour",
            joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "tour_id")}
    )
    private List<Tour> tours;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private List<Review> reviews;

    /**
     * Client's login
     */
    @NonNull
    private String login;

    /**
     * Client's password
     */
    @NonNull
    private String password;

    /**
     * Unique id of the client
     */
    @Enumerated(EnumType.STRING)
    @NonNull
    private Role role;
}
