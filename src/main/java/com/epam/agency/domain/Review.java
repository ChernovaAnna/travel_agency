package com.epam.agency.domain;

import lombok.*;

import java.time.LocalDate;

/**
 * Stores information about clients' reviews.
 * Implements the Identifier interface.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

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
    private long id;

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
    @NonNull
    private Client client;

    /**
     * Tour to which the review was written
     */
    @NonNull
    private Tour tour;
}
