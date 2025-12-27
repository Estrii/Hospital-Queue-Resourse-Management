package model;

public enum UrgencyLevel {
    CRITICAL(4),
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    public int priority;

    UrgencyLevel(int priority) {
        this.priority = priority;
    }
}