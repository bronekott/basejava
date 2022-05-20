package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class EventPointField extends Field {
    List<EventPoint> fields;

    public EventPointField(List<EventPoint> fields) {
        Objects.requireNonNull(fields, "textField must not be null");
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

        EventPointField eventPointField = (EventPointField) o;

        return Objects.equals(fields, eventPointField.fields);
    }

    @Override
    public int hashCode() {
        return fields.hashCode();
    }


}
