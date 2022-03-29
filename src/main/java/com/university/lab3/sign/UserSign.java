package com.university.lab3.sign;

import com.university.lab3.model.User;
import com.university.lab3.repository.UserRepository;

public class UserSign {

    private static final UserRepository STUDENT_REPOSITORY = new UserRepository();
    private static User signUser;

    public boolean sign(String userName, String password) {
        User foundedUser = STUDENT_REPOSITORY.findByName(userName);

        if (isPassword(password, foundedUser)) {
            signUser = foundedUser;
            System.out.println(signUser.getUserName());
            return true;
        } else {
            System.out.println("User not found enter");
        }
        return false;
    }

    private boolean isPassword(String password, User user) {
        return user.getPassword().equals(password);
    }

    public User getSignUser() {
        return signUser;
    }
}
