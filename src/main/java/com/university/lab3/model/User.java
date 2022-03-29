package com.university.lab3.model;

import java.io.Serializable;

public class User implements Serializable {

    private String role;
    private String userName;
    private String password;
    private double averageMark;
    private Faculty facultyToEnroll;
    private Faculty enrolledFaculty;

    public User(String role, String userName, String password) {
        this.role = role;
        this.userName = userName;
        this.password = password;
        averageMark = 0;
    }

    public User() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public Faculty getFacultyToEnroll() {
        return facultyToEnroll;
    }

    public void setFacultyToEnroll(Faculty facultyToEnroll) {
        this.facultyToEnroll = facultyToEnroll;
    }

    public Faculty getEnrolledFaculty() {
        return enrolledFaculty;
    }

    public void setEnrolledFaculty(Faculty enrolledFaculty) {
        this.enrolledFaculty = enrolledFaculty;
    }
}
