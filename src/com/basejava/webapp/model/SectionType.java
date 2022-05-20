package com.basejava.webapp.model;

public enum SectionType {
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATION("Квалификация"),
    EXPERIENCE("Опты работы"),
    EDUCATION("Образование");

    private String title;
    SectionType(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
