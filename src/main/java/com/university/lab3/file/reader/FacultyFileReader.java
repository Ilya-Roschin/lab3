package com.university.lab3.file.reader;

import com.university.lab3.file.array.Faculties;
import com.university.lab3.file.array.Users;
import com.university.lab3.model.Faculty;
import com.university.lab3.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FacultyFileReader {

    private static final String PATH = "src/main/java/com/university/lab3/file/data/faculty.bat";
    private static final File FILE = new File(PATH);

    public void clearFile() {
        try {
            FILE.delete();
            FILE.createNewFile();
        } catch (IOException e) {
            System.out.println("File Exeption");
        }
    }

    public List<Faculty> findAll() {
        FileInputStream fileInputStream = null;
        List<Faculty> facultiesList = new ArrayList<>();
        try {
            if (FILE.length() != 0) {
                fileInputStream = new FileInputStream(PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Faculties faculties = (Faculties) objectInputStream.readObject();
                facultiesList = faculties.getFaculties();
                objectInputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("IoExceprion");
        }
        return facultiesList;
    }

    public void addToFile(Faculty faculty) {
        FileOutputStream outputStream = null;
        List<Faculty> facultiesList = findAll();
        try {

            outputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            facultiesList.add(faculty);
            objectOutputStream.writeObject(new Faculties(facultiesList));

            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFaculty(Faculty faculty) {
        List<Faculty> facultyList = findAll();
        clearFile();
        for (int i = 0; i < facultyList.size(); i++) {
            if (Objects.equals(facultyList.get(i), faculty)) {
                facultyList.remove(faculty);
                break;
            }
        }

        for (Faculty element: facultyList) {
            addToFile(element);
        }
    }
}
