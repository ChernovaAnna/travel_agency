package com.epam.agency.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Hotel implements Identifier{
    private long id;
    @NonNull
    private String name;
    @NonNull
    private int stars;
    private String website;
    @NonNull
    private double lalitude;
    @NonNull
    private double longitude;
    @NonNull
    private List<Feature> feature;
}
