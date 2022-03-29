package com.university.lab3.init;

import com.university.lab3.model.User;
import com.university.lab3.repository.UserRepository;

public class Initialization {

    private static final UserRepository USER_REPOSITORY = new UserRepository();

    public void init() {
        USER_REPOSITORY.addUser(new User("User","Van","123"));
    }
}
