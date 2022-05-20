package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListField extends Field {
    private final List<String> fields;

    public ListField(List<String> fields) {
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

        ListField listField = (ListField) o;

        return Objects.equals(fields, listField.fields);
    }

    @Override
    public int hashCode() {
        return fields.hashCode();
    }
}


