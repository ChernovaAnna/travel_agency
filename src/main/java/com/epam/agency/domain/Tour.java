package com.epam.agency.domain;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Stores information about tours.
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
public class Tour implements Identifier {

    /**
     * Unique id of the tour
     */
    private long id;
    /**
     * Photo of the tour
     */
    private String photo;

    /**
     * Date of tour
     */
    @NonNull
    private LocalDate date;

    /**
     * Duration of the tour
     */
    @NonNull
    private int duration;

    /**
     * Description of the tour
     */
    private String description;

    /**
     * Tour's cost
     */
    @NonNull
    private double cost;

    /**
     * Type of the tour
     */
    @NonNull
    private TourType tourType;

    /**
     * Hotel which offered in the tour
     */
    @NonNull
    private Hotel hotel;

    /**
     * Country of the tour
     */
    @NonNull
    private Country country;

    /**
     * List of clients which have chosen the tour
     */
    private List<Client> clients;
}
