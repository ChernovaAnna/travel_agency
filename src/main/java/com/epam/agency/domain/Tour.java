package com.epam.agency.domain;


import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Tour implements Identifier {
    private long id;
    private String photo;
    private LocalDate date;
    private int duration;
    private String description;
    private double cost;
    private TourType tourType;
    private Hotel hotel;
    private Country country;
}
