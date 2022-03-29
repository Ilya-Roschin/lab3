package com.university.lab3.file.reader;

import com.university.lab3.file.array.Users;
import com.university.lab3.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserFileReader {

    private static final String PATH = "src/main/java/com/university/lab3/file/data/users.bat";
    private static final File FILE = new File(PATH);

    public void clearFile() {
        try {
            FILE.delete();
            FILE.createNewFile();
        } catch (IOException e) {
            System.out.println("File Exeption");
        }
    }

    public List<User> findAll() {
        FileInputStream fileInputStream = null;
        List<User> userList = new ArrayList<>();
        try {
            if (FILE.length() != 0) {
                fileInputStream = new FileInputStream(PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Users users = (Users) objectInputStream.readObject();
                userList = users.getUsers();
                objectInputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
         e.printStackTrace();
        }
        return userList;
    }

    public void addToFile(User user) {
        FileOutputStream outputStream = null;
        List<User> usersList = findAll();
        try {

            outputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            usersList.add(user);
            objectOutputStream.writeObject(new Users(usersList));

            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        List<User> userList = findAll();
        clearFile();
        for (int i = 0; i < userList.size(); i++) {
            if (Objects.equals(userList.get(i), user)) {
                userList.remove(user);
                break;
            }
        }

        for (User element: userList) {
            addToFile(element);
        }
    }
}
