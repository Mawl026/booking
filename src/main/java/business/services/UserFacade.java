package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

public class UserFacade
{
    UserMapper userMapper;

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException {
        return userMapper.login(email, password);
    }

    public User createUser(String email, String password, int phone, int credit, String role) throws UserException {
        User user = new User(email, password, phone, credit, role);
        userMapper.createUser(user);
        return user;
    }

    public void useCredit(int credit, int user_id) throws UserException {
        userMapper.useCredit(credit, user_id);
    }

}
