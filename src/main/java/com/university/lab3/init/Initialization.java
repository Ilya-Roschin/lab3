package com.university.lab3.init;

import com.university.lab3.model.Faculty;
import com.university.lab3.model.User;
import com.university.lab3.repository.FacultyRepository;
import com.university.lab3.repository.UserRepository;

public class Initialization {

    private static final UserRepository USER_REPOSITORY = new UserRepository();
    private static final FacultyRepository FACULTY_REPOSITORY = new FacultyRepository();


    public void initUsers() {
        USER_REPOSITORY.addUser(new User("User","Van","123"));
        USER_REPOSITORY.addUser(new User("User","Gayorgiy","123"));
        USER_REPOSITORY.addUser(new User("Admin","Admin","123"));
        USER_REPOSITORY.addUser(new User("User","Alex","123"));
        USER_REPOSITORY.addUser(new User("User","Vladislave","123"));
        USER_REPOSITORY.addUser(new User("User","Vlad","123"));
    }

    public void initFaculties() {
        FACULTY_REPOSITORY.addFaculty(new Faculty("Фкп", 6d));
        FACULTY_REPOSITORY.addFaculty(new Faculty("Радиоэлектроники", 3d));
        FACULTY_REPOSITORY.addFaculty(new Faculty("ЯУЗБЕК", 1d));
        FACULTY_REPOSITORY.addFaculty(new Faculty("ЯУЗБЕК2", 1d));
        FACULTY_REPOSITORY.addFaculty(new Faculty("ЯУЗБЕК3", 1d));
        FACULTY_REPOSITORY.addFaculty(new Faculty("ЯУЗБЕК4", 1d));
        FACULTY_REPOSITORY.addFaculty(new Faculty("ЯУЗБЕК5", 1d));
        FACULTY_REPOSITORY.addFaculty(new Faculty("Ксис", 9d));
    }
}
