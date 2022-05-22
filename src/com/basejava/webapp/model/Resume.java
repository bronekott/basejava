package com.basejava.webapp.model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private final String uuid;
    private final String fullName;
    private final Map<ContactType, String> contactInfo = new HashMap<ContactType, String>();
    private final Map<SectionType, AbstractSection> sections = new HashMap<SectionType, AbstractSection>();

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public AbstractSection getSection(SectionType st) {
        return sections.get(st);
    }

    public void addSection(SectionType st, AbstractSection info) {
        sections.put(st, info);
    }

    public String getContact(ContactType ct) {
        return contactInfo.get(ct);
    }

    public void addContact(ContactType ct, String info) {
        contactInfo.put(ct, info);
    }

    @Override
    public String toString() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        boolean equalsUuid = uuid.equals(resume.uuid);
        boolean equalsFullName = fullName.equals(resume.fullName);

        return equalsFullName && equalsUuid;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public int compareTo(Resume o) {
        int compare = fullName.compareTo(o.fullName);
        return compare == 0 ? uuid.compareTo(o.uuid) : compare;
    }
}
