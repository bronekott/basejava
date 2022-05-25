package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class Organization extends AbstractSection {
    private final List<Position> sections;

    public Organization(List<Position> sections) {
        Objects.requireNonNull(sections, "fields must not be null");
        this.sections = sections;
    }

    public List<Position> getSections() {
        return sections;
    }

    @Override
    public String toString() {
        return sections.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization eventPointField = (Organization) o;

        return Objects.equals(sections, eventPointField.sections);
    }

    @Override
    public int hashCode() {
        return sections.hashCode();
    }


}
