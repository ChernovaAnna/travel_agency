package com.epam.agency.domain;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Client implements Identifier {
    private long id;
    @NonNull
    private String login;
    @NonNull
    private String password;
}
