package com.epam.agency.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Stores information about tours.
 * Implements the Identifier interface.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

@Entity
@Table(name = "tour")
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
    @Column(name = "id")
    private long id;
    /**
     * Photo of the tour
     */
    @Column(name = "photo")
    private String photo;

    /**
     * Date of tour
     */
    @Column(name = "date")
    @NonNull
    private LocalDate date;

    /**
     * Duration of the tour
     */
    @Column(name = "duration")
    @NonNull
    private int duration;

    /**
     * Description of the tour
     */
    @Column(name = "description")
    private String description;

    /**
     * Tour's cost
     */
    @Column(name = "cost")
    @NonNull
    private double cost;

    /**
     * Type of the tour
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "tour_type")
    @NonNull
    private TourType tourType;

    /**
     * Hotel which offered in the tour
     */
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @NonNull
    private Hotel hotel;

    /**
     * Country of the tour
     */
    @ManyToOne
    @JoinColumn(name = "country_id")
    @NonNull
    private Country country;

    /**
     * List of clients which have chosen the tour
     */

    @ManyToMany
    @JoinTable(
            name = "client_tour",
            joinColumns = @JoinColumn(name = "tour_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "client_id", referencedColumnName = "ID"))
    private List<Client> clients;
}
