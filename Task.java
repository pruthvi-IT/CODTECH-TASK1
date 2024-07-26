package com.example.todo;

public class Task {
    private int id;
    private String description;
    private boolean completed;
    private String date;
    private String time;

    public Task(int id, String description, boolean completed, String date, String time) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
