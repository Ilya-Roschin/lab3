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
        USER_REPOSITORY.addUser(new User("User","Dan","123"));
        USER_REPOSITORY.addUser(new User("Admin","Boss","123"));
    }

    public void initFaculties() {
        FACULTY_REPOSITORY.addFaculty(new Faculty("Dungeon", 6d));
        FACULTY_REPOSITORY.addFaculty(new Faculty("Говна и палок", 3d));
        FACULTY_REPOSITORY.addFaculty(new Faculty("ЯУЗБЕК", 1d));
        FACULTY_REPOSITORY.addFaculty(new Faculty("Gym", 9d));
    }
}
