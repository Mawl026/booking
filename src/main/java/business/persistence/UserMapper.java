package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    private Database database;



    public UserMapper(Database database) {
        this.database = database;

    }



    public User createUser(User user) throws UserException {

        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO users (user_mail, user_password, user_phone, user_credit, user_role) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setInt(3, user.getPhone());
                ps.setInt(4, user.getCredit());
                ps.setString(5, user.getRole());

                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();


                int id = ids.getInt(1);
                user.setUser_id(id);

            }

            catch (SQLException ex) {
                throw new UserException(ex.getMessage());

            }
        }

        catch (SQLException ex) {
            throw new UserException(ex.getMessage());

        }
        return user;
    }



    public User login(String user_mail, String user_password) throws UserException {

        try (Connection connection = database.connect()) {
            String sql = "SELECT user_id, user_role FROM users WHERE user_mail=? AND user_password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, user_mail);
                ps.setString(2, user_password);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String user_role = rs.getString("user_role");
                    int id = rs.getInt("user_id");
                    User user = new User(user_mail, user_password,0,0, user_role);
                    user.setUser_id(id);
                    return user;

                }

                else {
                    throw new UserException("Could not validate user");

                }
            }

            catch (SQLException ex) {
                throw new UserException(ex.getMessage());

            }
        }

        catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");

        }
    }



    public List<User> listOfStudents() throws UserException {
        List<User> listOfStudents = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM users WHERE user_role='student'";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int user_id = rs.getInt("user_id");
                    String user_mail = rs.getString("user_mail");
                    String user_password = rs.getString("user_password");
                    int user_phone = rs.getInt("user_phone");
                    int user_credit = rs.getInt("user_credit");
                    String user_role = rs.getString("user_role");
                    User user = new User(user_mail, user_password, user_phone, user_credit, user_role);
                    user.setUser_id(user_id);
                    listOfStudents.add(user);

                }
            }
        }

        catch (SQLException exception) {
            exception.printStackTrace();
            throw new UserException(exception.getMessage());

        }

        return listOfStudents;
    }



    public int useCredit(int user_credit, int user_id) {

            try (Connection connection = database.connect()) {
                String sql = "update user set user_credit = user_credit - ? where user_id = ?";

                try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setInt(1, user_credit);
                    ps.setInt(2, user_id);
                    ps.executeUpdate();

                }

                catch (SQLException throwables) {
                    throwables.printStackTrace();

                }

            }

            catch (SQLException throwables) {
                throwables.printStackTrace();

            }

            return user_credit;
    }
}
