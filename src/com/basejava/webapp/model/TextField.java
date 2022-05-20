package com.basejava.webapp.model;

import java.util.Objects;

public class TextField extends Field{
    private String textField;

    public TextField(String textField){
        Objects.requireNonNull(textField,"textField must not be null");
        this.textField = textField;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    @Override
    public String toString() {
        return textField;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        TextField tf = (TextField) obj;

        return textField.equals(tf.textField);
    }

    @Override
    public int hashCode() {
        return textField.hashCode();
    }
}
