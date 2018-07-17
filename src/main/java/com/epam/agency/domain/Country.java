package com.epam.agency.domain;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Country implements Identifier {
    private long id;
    @NonNull
    private String name;
}
