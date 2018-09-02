package com.epam.agency.domain;

public enum Role {
    ADMIN,
    MEMBER;

    @Override
    public String toString() {
        return this.name();
    }
}
