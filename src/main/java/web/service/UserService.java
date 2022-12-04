package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void editUser(User user, int id);

    void deleteUser(int id);
    User getById(int id);
}
