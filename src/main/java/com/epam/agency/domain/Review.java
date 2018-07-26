package com.epam.agency.domain;

import lombok.*;

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
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Review implements Identifier {

    /**
     * Unique id of the review
     */
    @Column(name = "id")
    private long id;

    /**
     * Date of review's writing
     */
    @Column(name = "date")
    @NonNull
    private LocalDate date;

    /**
     * Review's text
     */
    @Column(name = "text")
    @NonNull
    private String text;

    /**
     * The Author of review
     */
    @ManyToOne
    @JoinColumn(name = "client_id")
    @NonNull
    private Client client;

    /**
     * Tour to which the review was written
     */
    @ManyToOne
    @JoinColumn(name = "tour_id")
    @NonNull
    private Tour tour;
}
