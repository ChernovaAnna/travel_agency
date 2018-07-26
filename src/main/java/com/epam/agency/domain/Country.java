package com.epam.agency.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Country implements Identifier {

    /**
     * Unique id of the country
     */
    @Column(name = "id")
    private long id;

    /**
     * Country's name
     */
    @Column(name = "name")
    @NonNull
    private String name;
}
