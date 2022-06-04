package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {
    private final List<Organization> sections;

    public OrganizationSection(List<Organization> sections) {
        Objects.requireNonNull(sections, "fields must not be null");
        this.sections = sections;
    }

    public List<Organization> getSections() {
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

        OrganizationSection eventPointField = (OrganizationSection) o;

        return Objects.equals(sections, eventPointField.sections);
    }

    @Override
    public int hashCode() {
        return sections.hashCode();
    }


}
