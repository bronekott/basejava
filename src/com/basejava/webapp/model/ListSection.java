package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection {
    private final List<String> fields;

    public ListSection(List<String> fields) {
        Objects.requireNonNull(fields, "fields must not be null");
        this.fields = fields;
    }

    public List<String> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return fields.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection listField = (ListSection) o;

        return Objects.equals(fields, listField.fields);
    }

    @Override
    public int hashCode() {
        return fields.hashCode();
    }
}


