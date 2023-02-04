package com.app.AIRS.Enum;

public enum AccountType {

    TRANSPORT("TRANSPORT"),
    MARKET("MARKET"),
    ENUMERATION("ENUMERATION"),
    PROPERTY("PROPERTY"),
    SUPER_ADMIN("SUPER_ADMIN"),
    ADMIN("ADMIN"),
    SUPER_ENROLMENT_OFFICER("SUPER_ENROLMENT_OFFICER"),
    ENROLMENT_OFFICER("ENROLMENT_OFFICER"),
    SUPER_AGENT("SUPER_AGENT"),
    AGENT("AGENT"),
    UTILITY("UTILITY");

    public final String label;

    AccountType(String label) {
        this.label = label;
    }
}
