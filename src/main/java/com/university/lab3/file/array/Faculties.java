package com.university.lab3.file.array;

import com.university.lab3.model.Faculty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Faculties implements Serializable {

    private List<Faculty> faculties = new ArrayList<>();

    public Faculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
