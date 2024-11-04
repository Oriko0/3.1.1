package ru.timkrug.crudspringboot311.dao;



import ru.timkrug.crudspringboot311.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUser(int id);
    void deleteUser(int id);
}
