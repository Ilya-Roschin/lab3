package com.university.lab3.model;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Double.compare(faculty.averageMark, averageMark) == 0 && Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, averageMark);
    }


}
