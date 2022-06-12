package com.basejava.webapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = createTestResume("uuid100", "Alex");

        for (Map.Entry<SectionType, AbstractSection> entry : resume.getSections().entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }

        for (Map.Entry<ContactType, String> entry : resume.getContactInfo().entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }

    public static Resume createTestResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);

        List<String> testAchievement = new ArrayList<>();
        testAchievement.add("testAchievement1");
        testAchievement.add("testAchievement2");
        testAchievement.add("testAchievement3");

        List<String> testQualification = new ArrayList<>();
        testAchievement.add("testQualification1");


        //first company Positions
        List<Organization.Position> testExperienceCompanyOne = new ArrayList<>();
        testExperienceCompanyOne.add(new Organization.Position(LocalDate.of(2020, 5, 25), LocalDate.of(2021, 5, 25), "Software Developer", "Description of main duties"));
        testExperienceCompanyOne.add(new Organization.Position(LocalDate.of(2021, 5, 26), LocalDate.of(2022, 5, 25), "Senior Software Developer", "Another description of main duties"));

        //second company Positions
        List<Organization.Position> testExperienceCompanyTwo = new ArrayList<>();
        testExperienceCompanyOne.add(new Organization.Position(LocalDate.of(2022, 5, 25), LocalDate.now(), "Team Lead", "Description of team lead role"));

        //Education positions
        List<Organization.Position> testEducationPositions = new ArrayList<>();
        testEducationPositions.add(new Organization.Position(LocalDate.of(2010, 9, 15), LocalDate.of(2014, 6, 25), "Some degree", null));

        // Organizations
        List<Organization> testOrganizations = new ArrayList<>();
        testOrganizations.add(new Organization("FirstJob company", "www.first.co", testExperienceCompanyOne));
        testOrganizations.add(new Organization("SecondJob company", "www.second.co", testExperienceCompanyTwo));

        //Education
        List<Organization> testEducation = new ArrayList<>();
        testEducation.add(new Organization("Yale", "www.yale.co", testEducationPositions));

        resume.addContact(ContactType.PHONE_NUMBER, "89169097788");
        resume.addContact(ContactType.EMAIL, "mail@tempmail.org");
        resume.addContact(ContactType.GITHUB, "https://github.com/bronekott/basejava");
        resume.addContact(ContactType.SKYPE, "@skype_login");
        resume.addContact(ContactType.HOMEPAGE, null);
        resume.addContact(ContactType.LINKEDIN, "https://www.linkedin.com/");
        resume.addContact(ContactType.STACKOVERFLOW, null);

        resume.addSection(SectionType.PERSONAL, new TextSection("Testing personal info"));
        resume.addSection(SectionType.OBJECTIVE, new TextSection("Looking for a job as a Software Developer"));

        resume.addSection(SectionType.ACHIEVEMENT, new ListSection(testAchievement));
        resume.addSection(SectionType.QUALIFICATION, new ListSection(testQualification));

        resume.addSection(SectionType.EXPERIENCE, new OrganizationSection(testOrganizations));
        resume.addSection(SectionType.EDUCATION, new OrganizationSection(testEducation));

        return resume;
    }
}
