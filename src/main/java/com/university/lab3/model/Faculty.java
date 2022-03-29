package com.university.lab3.model;

import java.io.Serializable;

public class Faculty implements Serializable {

    private String name;
    private double averageMark;


    public Faculty(String name, double averageMark) {
        this.name = name;
        this.averageMark = averageMark;
    }

    public Faculty() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
}
