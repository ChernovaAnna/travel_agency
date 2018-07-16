package com.epam.agency.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Hotel implements Identifier{
    private long id;
    private String name;
    private int stars;
    private String website;
    private double lalitude;
    private double longitude;
    private Feature feature;
}
