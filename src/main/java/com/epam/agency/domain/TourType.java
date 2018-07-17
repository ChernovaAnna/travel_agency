package com.epam.agency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum TourType {
    CRUISE("cruise"),
    ECO("eco"),
    GASTRO("gastro"),
    WEDDING("wedding"),
    EXTREME("extreme"),
    SHOPPING("shopping");

    @NonNull
    private String value;
}
