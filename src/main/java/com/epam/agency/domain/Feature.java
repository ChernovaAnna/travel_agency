package com.epam.agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * Stores hotel features.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */

@Getter
@AllArgsConstructor
public enum Feature {
    COMPLIMENTARY_WIFI("complimentary wifi"),
    BEAUTY_SALON_AND_SPA("beauty salon and spa"),
    KIDS_CLUB("kids club"),
    BABYSITTING_SERVICE("babysitting service"),
    ROOM_SERVICE("room service"),
    SELF_PARKING("self parking"),
    BUSINESS_CENTER("business center"),
    AIRPORT_TRANSFER("airport transfer"),
    FITNESS_CENTER("fitness_center"),
    HOTEL_SHOP("hotel_shop");

    /**
     * Value of enum feature
     */
    @NonNull
    private String value;
}
