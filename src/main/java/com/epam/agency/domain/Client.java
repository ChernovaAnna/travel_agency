package com.epam.agency.domain;

import lombok.*;

import java.util.List;

/**
 * Stores information about clients.
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
public class Client implements Identifier {

    /**
     * Unique id of the client
     */
    private long id;

    /**
     * Client's login
     */
    @NonNull
    private String login;

    /**
     * Client's password
     */
    @NonNull
    private String password;

    /**
     * List of tours visited by the client
     */
    List<Tour> tours;

    /**
     * List of reviews wrote by the client
     */
    List<Review> reviews;
}
