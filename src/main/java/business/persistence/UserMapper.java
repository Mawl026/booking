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



    public void createUser(User user) throws UserException {

        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO user (email, password, phone, credit, role) VALUES (?, ?, ?, ?, ?)";

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
    }



    public User login(String email, String password) throws UserException {

        try (Connection connection = database.connect()) {
            String sql = "SELECT id, role FROM users WHERE email=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String role = rs.getString("role");
                    int id = rs.getInt("user_id");
                    User user = new User(email, password,0,0, role);
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
            String sql = "SELECT * FROM user WHERE role='student'";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int user_id = rs.getInt("user_id");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    int phone = rs.getInt("phone");
                    int credit = rs.getInt("credit");
                    String role = rs.getString("role");
                    User user = new User(email, password, phone, credit, role);
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



    public int useCredit(int credit, int user_id) {

            try (Connection connection = database.connect()) {
                String sql = "update user set credit = credit - ? where user_id = ?";

                try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setInt(1, credit);
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

            return credit;
    }
}
