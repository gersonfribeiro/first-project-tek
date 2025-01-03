package com.example.demo.domain.tasks;

public enum PriorityTask {
    LOW, MEDIUM, HIGH;

    public static PriorityTask getPriorityTask(double priority) {
        if (priority < 0) {
            throw new IllegalArgumentException("Priority cannot be negative: " + priority);
        }
        if (priority <= 1.5) {
            return LOW;
        } else if (priority <= 2.5) {
            return MEDIUM;
        } else {
            return HIGH;
        }
    }
}
