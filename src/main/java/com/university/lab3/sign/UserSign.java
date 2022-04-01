package com.university.lab3.sign;

import com.university.lab3.model.User;
import com.university.lab3.repository.UserRepository;

import java.util.Objects;

public class UserSign {

    private static final UserRepository STUDENT_REPOSITORY = new UserRepository();
    private static User signUser;

    public boolean sign(String userName, String password) {
        User foundedUser = STUDENT_REPOSITORY.findByName(userName);

        if (isPassword(password, foundedUser)) {
            signUser = foundedUser;
            return true;
        } else {
            System.out.println("User not found enter");
        }
        return false;
    }

    private boolean isPassword(String password, User user) {
        return Objects.equals(user.getPassword(), password);

    }

    public User getSignUser() {
        return signUser;
    }
}
