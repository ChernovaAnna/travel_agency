package com.epam.agency.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Stores information about clients' reviews.
 * Implements the Identifier interface.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */
@Entity
@Table(name = "review")
@Getter
@Setter
public class Review extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Date of review's writing
     */
    @NonNull
    private LocalDate date;

    /**
     * Review's text
     */
    @NonNull
    private String text;

    /**
     * The Author of review
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    @NonNull
    private Client client;

    /**
     * Tour to which the review was written
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id")
    @NonNull
    private Tour tour;
}
