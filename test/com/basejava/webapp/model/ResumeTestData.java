package com.basejava.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

        for (String str : listSection.getSections()) {
            System.out.println(str);
        }

        for (Position pos : organization.getSections()) {
            System.out.println(pos);
        }

        System.out.println(resume.getContact(ContactType.PHONE_NUMBER));

    }
}
