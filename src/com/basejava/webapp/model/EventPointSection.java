package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class EventPointSection extends AbstractSection {
    private final List<EventPoint> fields;

    public EventPointSection(List<EventPoint> fields) {
        Objects.requireNonNull(fields, "fields must not be null");
        this.fields = fields;
    }

    public List<EventPoint> getFields() {
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

        EventPointSection eventPointField = (EventPointSection) o;

        return Objects.equals(fields, eventPointField.fields);
    }

    @Override
    public int hashCode() {
        return fields.hashCode();
    }


}
