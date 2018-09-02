package com.epam.agency.exception.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessExceptionCode {
    USER_NOT_FOUND(1), 
    NO_USERS_FOUND(2),
    COUNTRY_NOT_FOUND(3),
    NO_COUNTRIES_FOUND(4), 
    HOTEL_NOT_FOUND(5), 
    NO_HOTELS_FOUND(6), 
    REVIEW_NOT_FOUND(7),
    NO_REVIEWS_FOUND(8),
    TOUR_NOT_FOUND(9),
    NO_TOURS_FOUND(10);

    private Integer code;
}
