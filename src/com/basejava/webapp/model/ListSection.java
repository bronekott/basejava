package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection {
    private static final long serialVersionUID = 1L;
    private final List<String> sections;

    public ListSection(List<String> sections) {
        Objects.requireNonNull(sections, "fields must not be null");
        this.sections = sections;
    }

    public List<String> getSections() {
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

        ListSection listField = (ListSection) o;

        return Objects.equals(sections, listField.sections);
    }

    @Override
    public int hashCode() {
        return sections.hashCode();
    }
}


