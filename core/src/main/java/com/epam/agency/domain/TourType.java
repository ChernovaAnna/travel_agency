package com.epam.agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * Stores tour types.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public enum TourType {
    CRUISE("cruise"),
    ECO("eco"),
    GASTRO("gastro"),
    WEDDING("wedding"),
    EXTREME("extreme"),
    SHOPPING("shopping"),
    ESCORTED("escorted"),
    SIGHTSEEING("sightseeing"),
    FESTIVAL("festival"),
    BUS("bus");

    /**
     * Value of enum tour types
     */
    @NonNull
    private String value;
}
