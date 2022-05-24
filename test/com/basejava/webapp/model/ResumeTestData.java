package com.basejava.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("uuid100", "TestName");
        List<String> testList = new ArrayList<>();
        testList.add("Test1");
        testList.add("Test2");
        testList.add("Test3");

        List<String> testText = new ArrayList<>();
        testText.add("Test11");
        testText.add("Test22");
        testText.add("Test33");

        List<String> testEventPoint = new ArrayList<>();
        testEventPoint.add("Test111");
        testEventPoint.add("Test222");
        testEventPoint.add("Test333");

        resume.addContact(ContactType.PHONE_NUMBER, "89169097788");
        resume.addSection(SectionType.PERSONAL, new ListSection(testText));
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection(testList));
        resume.addSection(SectionType.EDUCATION, new ListSection(testEventPoint));

        ListSection as = (ListSection) resume.getSection(SectionType.ACHIEVEMENT);

        for (String str : as.getFields()) {
            System.out.println(str);
        }

        System.out.println(resume.getContact(ContactType.PHONE_NUMBER));

    }
}
