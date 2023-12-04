package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.DaoUser;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private DaoUser daoUser;
    @Autowired
    public UserServiceImpl(DaoUser daoUser) {
        this.daoUser = daoUser;
    }
    @Override
    public List<User> getUsers() {
        return daoUser.getUsers();
    }

    @Override
    public void addUser(User user) {
         daoUser.addUser(user);
    }

    @Override
    public void deleteUser(long id) {
        daoUser.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        daoUser.updateUser(user);
    }

    @Override
    public User getUserById(long id) {
        return daoUser.getUserById(id);
    }
}
