package com.university.lab3.repository;

import com.university.lab3.file.FileReader;
import com.university.lab3.model.User;

import java.util.List;
import java.util.Objects;

public class UserRepository {

    private static final FileReader FILE_READER = new FileReader();

    public void addUser(User user) {
            FILE_READER.addToFile(user);
    }

    public List<User> findAll() {
       return FILE_READER.findAll();
    }

    public User findByName(String username) {
        for (User element : FILE_READER.findAll()) {
            if (Objects.equals(element.getUserName(), username)) {
                return element;
            }
        }
        return new User();
    }

    public void updateUser(String username, User updatedUser) {
        if (!findByName(username).equals("empty")) {
            FILE_READER.deleteStudent(findByName(username));
            FILE_READER.addToFile(updatedUser);
        } else {
            System.out.println("User not founded");
        }
    }

}
