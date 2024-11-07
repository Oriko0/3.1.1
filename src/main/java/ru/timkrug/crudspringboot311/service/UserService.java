package ru.timkrug.crudspringboot311.service;



import ru.timkrug.crudspringboot311.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUser(int id);
    void deleteUser(int id);
    void updateInfo(User user);
}
