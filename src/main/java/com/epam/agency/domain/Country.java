package com.epam.agency.domain;

import lombok.*;

/**
 * Stores information about countries.
 * Implements the Identifier interface.
 *
 * @author Hanna_Charnova
 * @version 1.0
 */


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Country implements Identifier {

    /**
     * Unique id of the country
     */
    private long id;

    /**
     * Country's name
     */
    @NonNull
    private String name;
}
