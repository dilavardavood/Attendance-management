package services.serviceimpl;

import daos.UserDao;
import models.users.User;
import services.UserService;

import javax.inject.Inject;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Inject
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User authenticateUser(String username, String password) {
        User user = userDao.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    @Override
    public void registerUser(User user) {
        userDao.addUser(user);
    }
}
