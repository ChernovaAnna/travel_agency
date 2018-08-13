package com.epam.agency.domain;

import lombok.*;

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
@NamedQueries({
        @NamedQuery(name = Country.FIND_COUNTRY_BY_ID, query = "FROM Country c WHERE c.id=:id"),
        @NamedQuery(name = Country.DELETE_COUNTRY, query = "DELETE FROM Country c WHERE c.id=:id")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Country implements Identifier {

    public final static String FIND_COUNTRY_BY_ID = "findCountryById";
    public final static String DELETE_COUNTRY = "deleteCountry";
    /**
     * Unique id of the country
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Country's name
     */
    @Column(name = "name")
    @NonNull
    private String name;
}
