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

        resume.addContact(ContactType.PHONE_NUMBER, "89169097788");
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection(testList));

        for (String string : testList) {
            System.out.println(string);
        }

        System.out.println(resume.getContact(ContactType.PHONE_NUMBER));

    }
}