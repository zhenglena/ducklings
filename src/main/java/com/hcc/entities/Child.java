package com.hcc.entities;

import java.time.LocalDate;
import java.util.List;

public class Child {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private Classroom classroom;
    private List<User> familyUsers;
    private List<DailyLog> dailyLog;
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public List<User> getFamilyUsers() {
        return familyUsers;
    }

    public void setFamilyUsers(List<User> familyUsers) {
        this.familyUsers = familyUsers;
    }

    public List<DailyLog> getDailyLog() {
        return dailyLog;
    }

    public void setDailyLog(List<DailyLog> dailyLog) {
        this.dailyLog = dailyLog;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
