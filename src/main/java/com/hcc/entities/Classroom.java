package com.hcc.entities;

import java.util.List;

public class Classroom extends User {
    private Long classroomId;
    private String name;
    private AgeGroupEnum ageGroup;
    private List<Child> children;
    private String username;
    private String password;
    private List<Authority> authorities;



}
