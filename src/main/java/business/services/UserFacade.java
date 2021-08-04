package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

import java.util.List;

public class UserFacade {
    UserMapper userMapper;


    public UserFacade(Database database) {
        userMapper = new UserMapper(database);

    }


    public User login(String user_email, String user_password) throws UserException {
        return userMapper.login(user_email, user_password);

    }


    public User createUser(String user_email, String user_password, int user_phone, int user_credit, String user_role) throws UserException {
        User user = new User(user_email, user_password, user_phone, user_credit, user_role);
        user = userMapper.createUser(user);

        return user;
    }


    public List<User> listOfStudents() throws UserException {
        return userMapper.listOfStudents();

    }


    public void useCredit(int user_credit, int user_id) throws UserException {
        userMapper.useCredit(user_credit, user_id);

    }
}
