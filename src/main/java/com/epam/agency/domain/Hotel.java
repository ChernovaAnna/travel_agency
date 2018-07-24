package com.epam.agency.domain;

import lombok.*;

import java.util.List;

/**
 * Stores information about hotels.
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
public class Hotel implements Identifier {

    /**
     * Unique id of the hotel
     */
    private long id;

    /**
     * Hotel's name
     */
    @NonNull
    private String name;

    /**
     * Number of hotel's stars
     */
    @NonNull
    private int stars;

    /**
     * Hotel's website address
     */
    private String website;

    /**
     * Hotel's location lalitude
     */
    @NonNull
    private double lalitude;

    /**
     * Hotel's location longitude
     */
    @NonNull
    private double longitude;

    /**
     * List of hotel's features
     */
    @NonNull
    private List<Feature> feature;
}
