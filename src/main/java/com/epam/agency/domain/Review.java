package com.epam.agency.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Review implements Identifier {
    private long id;
    private LocalDate date;
    private String text;
    private Client client;
    private Tour tour;
}
