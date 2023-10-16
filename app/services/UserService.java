package services;

import com.google.inject.ImplementedBy;
import models.users.User;
import services.serviceimpl.UserServiceImpl;

@ImplementedBy(UserServiceImpl.class)
public interface UserService {
    User authenticateUser(String username, String password);
    void registerUser(User user);
}
