package com.basejava.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Position {
    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String position;
    private String description;

    public Position(String companyName, LocalDate startTime, LocalDate endTime, String position, String description) {
        //Objects.requireNonNull(startDate, "startDate must not be null");
        //Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(position, "position must not be null");
        Objects.requireNonNull(description, "description must not be null");
        this.companyName = companyName;
        this.startDate = startTime;
        this.endDate = endTime;
        this.position = position;
        this.description = description;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position that = (Position) o;

        if (!Objects.equals(companyName, that.companyName)) return false;
        if (!Objects.equals(startDate, that.startDate)) return false;
        if (!Objects.equals(endDate, that.endDate)) return false;
        if (!Objects.equals(position, that.position)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = companyName != null ? companyName.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EventPoint{" +
                "companyName='" + companyName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
