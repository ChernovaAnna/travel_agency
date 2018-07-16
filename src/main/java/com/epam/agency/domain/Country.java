package com.epam.agency.domain;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Country implements Identifier {
    private long id;
    private String name;
}
