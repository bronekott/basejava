package com.basejava.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {

    private final Link homePage;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String position;
    private final String description;

    public Organization(String companyName, String url, LocalDate startTime, LocalDate endTime, String position, String description) {
        //Objects.requireNonNull(startDate, "startDate must not be null");
        //Objects.requireNonNull(endDate, "endDate must not be null");
        //Objects.requireNonNull(position, "position must not be null");
        //Objects.requireNonNull(description, "description must not be null");
        this.homePage = new Link(companyName, url);
        this.startDate = startTime;
        this.endDate = endTime;
        this.position = position;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        if (!Objects.equals(startDate, that.startDate)) return false;
        if (!Objects.equals(endDate, that.endDate)) return false;
        if (!Objects.equals(position, that.position)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
