package com.epam.agency.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Stores information about hotels.
 * Implements the Identifier interface.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

@Entity
@Table(name = "hotel")
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
    @Column(name="id")
    private long id;

    /**
     * Hotel's name
     */
    @Column(name="name")
    @NonNull
    private String name;

    /**
     * Number of hotel's stars
     */
    @Column(name="stars")
    @NonNull
    private int stars;

    /**
     * Hotel's website address
     */
    @Column(name="website")
    private String website;

    /**
     * Hotel's location lalitude
     */
    @Column(name = "lalitude")
    @NonNull
    private double lalitude;

    /**
     * Hotel's location longitude
     */
    @Column(name = "longitude")
    @NonNull
    private double longitude;

    /**
     * List of hotel's features
     */
    @ElementCollection


    @Column(name = "feature")
    @NonNull
    private List<Feature> feature;
}
