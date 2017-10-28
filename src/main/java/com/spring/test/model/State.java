package com.spring.test.model;

public enum State {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    DELETED("DELETED"),
    LOCKED("LOCKED");

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

    @Override
    public String toString() {
        return this.state;
    }
}
