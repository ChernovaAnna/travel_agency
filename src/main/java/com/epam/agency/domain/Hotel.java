package com.epam.agency.domain;

import com.epam.agency.repository.mapper.FeatureListConverter;
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
@NamedQueries({
        @NamedQuery(name = Hotel.FIND_HOTEL_BY_ID, query = "FROM Hotel h WHERE h.id=:id"),
        @NamedQuery(name = Hotel.DELETE_HOTEL, query = "DELETE FROM Hotel h WHERE h.id=:id")
})

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Hotel implements Identifier {
    public final static String FIND_HOTEL_BY_ID = "findHotelById";
    public final static String DELETE_HOTEL = "deleteHotel";

    /**
     * Unique id of the hotel
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Hotel's name
     */
    @Column(name = "name")
    @NonNull
    private String name;

    /**
     * Number of hotel's stars
     */
    @Column(name = "stars")
    @NonNull
    private int stars;

    /**
     * Hotel's website address
     */
    @Column(name = "website")
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

    @Column(name = "features")
    @Convert(converter = FeatureListConverter.class)
    @NonNull
    private List<Feature> feature;
}
