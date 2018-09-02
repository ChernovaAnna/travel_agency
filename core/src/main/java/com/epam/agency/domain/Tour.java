package com.epam.agency.domain;

import com.epam.agency.mapper.TourTypeConverter;
import lombok.*;
import org.dom4j.tree.AbstractEntity;

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
public class Tour extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
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
    @Column(name = "tour_type")
    @Convert(converter = TourTypeConverter.class)
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
    @ManyToMany(mappedBy = "tours")
    private List<Client> clients;
}
