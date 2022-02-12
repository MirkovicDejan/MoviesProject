package com.moviesproject.moviesproject.securityconfig;

public enum RolePremission {

    ADMIN("ADMIN"),USER("USER"),SUPER_USER("SUPER_USER"),GUEST("GUEST"),TEST("TEST");

    private final String premission;

    RolePremission(String premission) {
        this.premission = premission;
    }

    public String getPremission() {
        return premission;
    }
}
