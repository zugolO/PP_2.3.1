package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void editUser(User user, int id) {
        userDao.editUser(user, id);

    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);

    }

    @Override
    @Transactional(readOnly = true)
    public User getById(int id) {
        return userDao.getById(id);
    }
}


