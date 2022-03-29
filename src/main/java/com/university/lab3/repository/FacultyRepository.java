package com.university.lab3.repository;

import com.university.lab3.file.reader.FacultyFileReader;
import com.university.lab3.file.reader.UserFileReader;
import com.university.lab3.model.Faculty;
import com.university.lab3.model.User;

import java.util.List;
import java.util.Objects;

public class FacultyRepository {

    private static final FacultyFileReader FILE_READER = new FacultyFileReader();

    public void addFaculty(Faculty faculty) {
        FILE_READER.addToFile(faculty);
    }

    public List<Faculty> findAll() {
        return FILE_READER.findAll();
    }

    public Faculty findByName(String name) {
        for (Faculty element : FILE_READER.findAll()) {
            if (Objects.equals(element.getName(), name)) {
                return element;
            }
        }
        return new Faculty();
    }

    public void updateFaculty(String name, Faculty updatedFaculty) {
        if (!findByName(name).equals("empty")) {
            FILE_READER.deleteFaculty(findByName(name));
            FILE_READER.addToFile(updatedFaculty);
        } else {
            System.out.println("Faculty not founded");
        }
    }

}
