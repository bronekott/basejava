package com.basejava.webapp.model;

import java.util.Objects;

public class TextSection extends AbstractSection {
    private static final long serialVersionUID = 1L;
    private String textNote;

    public TextSection(String textNote) {
        Objects.requireNonNull(textNote, "textField must not be null");
        this.textNote = textNote;
    }

    public String getTextNote() {
        return textNote;
    }

    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

    @Override
    public String toString() {
        return textNote;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        TextSection tf = (TextSection) obj;

        return textNote.equals(tf.textNote);
    }

    @Override
    public int hashCode() {
        return textNote.hashCode();
    }
}
