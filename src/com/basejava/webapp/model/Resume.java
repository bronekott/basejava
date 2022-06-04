package com.basejava.webapp.model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private final String uuid;
    private final String fullName;
    private final Map<ContactType, String> contactInfo = new EnumMap<>(ContactType.class);
    private final Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);

    public Map<ContactType, String> getContactInfo() {
        return contactInfo;
    }

    public Map<SectionType, AbstractSection> getSections() {
        return sections;
    }

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

    public String getContact(ContactType ct) {
        return contactInfo.get(ct);
    }

    public void addSection(SectionType st, AbstractSection info) {
        sections.put(st, info);
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

        if (uuid != null ? !uuid.equals(resume.uuid) : resume.uuid != null) return false;
        if (fullName != null ? !fullName.equals(resume.fullName) : resume.fullName != null) return false;
        if (!contactInfo.equals(resume.contactInfo)) return false;
        return sections.equals(resume.sections);
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + contactInfo.hashCode();
        result = 31 * result + sections.hashCode();
        return result;
    }

    @Override
    public int compareTo(Resume o) {
        int compare = fullName.compareTo(o.fullName);
        return compare == 0 ? uuid.compareTo(o.uuid) : compare;
    }
}
