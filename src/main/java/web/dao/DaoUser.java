package web.dao;

import web.model.User;

import java.util.List;

public interface DaoUser {
    List<User> getUsers();
    void addUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
    User getUserById(long id);

}
