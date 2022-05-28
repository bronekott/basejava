package com.basejava.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("uuid100", "TestName");

        List<String> testList = new ArrayList<>();
        testList.add("Test1");
        testList.add("Test2");
        testList.add("Test3");

        List<Position> testPosition = new ArrayList<>();
        testPosition.add(new Position("Test Company Name", LocalDate.of(2020, 5, 25), LocalDate.of(2021, 5, 25), "Software Developer", "Description of main duties"));
        testPosition.add(new Position("Another Test Company Name", LocalDate.of(2021, 5, 26), LocalDate.of(2022, 5, 25), "Senior Software Developer", "Another description of main duties"));

        resume.addContact(ContactType.PHONE_NUMBER, "89169097788");
        resume.addSection(SectionType.PERSONAL, new TextSection("Testing personal info"));
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection(testList));
        resume.addSection(SectionType.EXPERIENCE, new Organization(testPosition));

        ListSection listSection = (ListSection) resume.getSection(SectionType.ACHIEVEMENT);
        Organization organization = (Organization) resume.getSection(SectionType.EXPERIENCE);

        for (Map.Entry<SectionType, AbstractSection> entry : resume.getSections().entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }

        for (Map.Entry<ContactType, String> entry : resume.getContactInfo().entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }


    }
}
