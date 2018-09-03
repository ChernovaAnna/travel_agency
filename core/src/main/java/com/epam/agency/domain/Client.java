package com.epam.agency.domain;

import lombok.*;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;

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
@ToString
@EqualsAndHashCode
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
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "client_tour", joinColumns = @JoinColumn(name = "client_id",
//            referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tour_id",
//            referencedColumnName = "id"))
//    private List<Tour> tours;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "review", cascade = CascadeType.ALL)
//    private List<Review> reviews;

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
