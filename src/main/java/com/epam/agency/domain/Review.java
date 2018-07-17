package com.epam.agency.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Review implements Identifier {
    private long id;
    @NonNull
    private LocalDate date;
    @NonNull
    private String text;
    @NonNull
    private Client client;
    @NonNull
    private Tour tour;
}
