package com.spring.test.model;

public enum State {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted"),
    LOCKED("Locked");

    private String state;

    State(final String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String getName() {
        return this.name();
    }
}
