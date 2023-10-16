package daos;

import com.google.inject.ImplementedBy;
import daos.daoimpl.UserDaoImpl;
import models.users.User;

@ImplementedBy(UserDaoImpl.class)
public interface UserDao {
    User getUserByUsername(String username);
    void addUser(User user);
}
