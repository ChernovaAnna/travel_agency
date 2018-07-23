package com.epam.agency.domain;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Tour implements Identifier {
    private long id;
    private String photo;
    @NonNull
    private LocalDate date;
    @NonNull
    private int duration;
    private String description;
    @NonNull
    private double cost;
    @NonNull
    private TourType tourType;
    @NonNull
    private Hotel hotel;
    @NonNull
    private Country country;
    private List<Client> clients;
}
