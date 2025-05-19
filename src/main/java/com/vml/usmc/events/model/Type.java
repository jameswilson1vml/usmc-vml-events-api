package com.vml.usmc.events.model;

public enum Type {
    NATIONAL_PARTNERSHIP("National Partnership"),
    OFFICER_EVENT ("Officer Event"),
    INFLUENCER_EVENT("Influencer Event"),
    BATTLE_POSITION("Battle Position"),
    RS_DISTRICT_INFLUENCER_EVENT("RS District Influencer Event");

    private final String type;

    Type(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
