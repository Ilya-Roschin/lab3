package com.university.lab3.repository;

import com.university.lab3.file.reader.UserFileReader;
import com.university.lab3.model.User;
import com.university.lab3.sign.UserSign;

import java.util.List;
import java.util.Objects;

public class UserRepository {

    private static final UserFileReader FILE_READER = new UserFileReader();

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
            FILE_READER.deleteUser(findByName(username));
            FILE_READER.addToFile(updatedUser);
        } else {
            System.out.println("User not founded");
        }
    }
    public void deleteUser(String username) {
        FILE_READER.deleteUser(findByName(username));
    }

    public void autoUpdateUserInfo() {
        try {
            User user = findByName((new UserSign()).getSignUser().getUserName());
            if (user.getAverageMark() >= user.getFacultyToEnroll().getAverageMark()) {
                user.setEnrolledFaculty(user.getFacultyToEnroll());
            }
            updateUser(user.getUserName(), user);
        } catch (NullPointerException e) {
            System.out.println("Ошибка обновления");
        }

    }

}
