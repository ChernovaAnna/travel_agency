package com.epam.agency.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PageName {
    HOME("home"),
    REDIRECT("redirect:/"),
    SIGN_IN("sign_in"),
    SIGN_UP("sign_up"),
    TOURS("tours"),
    REVIEWS("reviews"),
    HOTELS("hotels"),
    COUNTRIES("countries"),
    ERROR("error");

    private String value;
}
