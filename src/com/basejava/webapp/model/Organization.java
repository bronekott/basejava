package com.basejava.webapp.model;

import java.time.LocalDate;
import java.util.List;

public class Organization {
    private final Link homepage;
    private final List<Position> positions;

    public Organization(String companyName, String homepage, List<Position> positions) {
        this.homepage = new Link(companyName, homepage);
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public static class Position {
        private final LocalDate startDate;
        private final LocalDate endDate;
        private final String position;
        private final String description;

        public Position(LocalDate startTime, LocalDate endTime, String position, String description) {
            //Objects.requireNonNull(startDate, "startDate must not be null");
            //Objects.requireNonNull(endDate, "endDate must not be null");
            //Objects.requireNonNull(position, "position must not be null");
            //Objects.requireNonNull(description, "description must not be null");
            this.startDate = startTime;
            this.endDate = endTime;
            this.position = position;
            this.description = description;
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
        public int hashCode() {
            int result = startDate != null ? startDate.hashCode() : 0;
            result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
            result = 31 * result + (position != null ? position.hashCode() : 0);
            result = 31 * result + (description != null ? description.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", position='" + position + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position1 = (Position) o;

            if (!startDate.equals(position1.startDate)) return false;
            if (!endDate.equals(position1.endDate)) return false;
            if (!position.equals(position1.position)) return false;
            return description.equals(position1.description);
        }
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homepage=" + homepage +
                ", positions=" + positions +
                '}';
    }
}
