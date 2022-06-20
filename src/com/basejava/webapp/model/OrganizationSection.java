package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {
    private static final long serialVersionUID = 1L;
    private final List<Organization> organizations;

    public OrganizationSection(List<Organization> sections) {
        Objects.requireNonNull(sections, "fields must not be null");
        this.organizations = sections;
    }

    public List<Organization> getSections() {
        return organizations;
    }

    @Override
    public String toString() {
        return "OrganizationSection{" +
                "organizations=" + organizations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection eventPointField = (OrganizationSection) o;

        return Objects.equals(organizations, eventPointField.organizations);
    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }

}
