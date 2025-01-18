package org.zahin.DrivingSpotter.constants;

public enum ReviewStatus {
    REVIEWED("Reviewed"),
    IN_PROGRESS("In Progress");

    private final String displayValue;

    ReviewStatus(final String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
