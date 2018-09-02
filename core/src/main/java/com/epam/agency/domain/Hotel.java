package com.epam.agency.domain;

import com.epam.agency.mapper.FeatureListConverter;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.dom4j.tree.AbstractEntity;

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
public class Hotel extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Convert(converter = FeatureListConverter.class)
    @NonNull
    private List<Feature> features;
}
