package com.epam.agency.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;

/**
 * Stores information about countries.
 * Implements the Identifier interface.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */
@Entity
@Table(name = "country")
@Getter
@Setter
public class Country extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Country's name
     */
    @NonNull
    private String name;
}
