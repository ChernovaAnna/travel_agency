package com.epam.agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum Feature {
    COMPLIMENTARY_WIFI("complimentary wifi"),
    BEAUTY_SALON_AND_SPA("beauty salon and spa"),
    KIDS_CLUB("kids club"),
    BABYSITTING_SERVICE("babysitting services"),
    ROOM_SERVICE("room service"),
    SELF_PARKING("self parking"),
    BUSINESS_CENTER("business center"),
    AIRPORT_TRANSFER("airport transfer");

    @NonNull
    private String value;
}
