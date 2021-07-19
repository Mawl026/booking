package business.persistence;

import business.entities.Booking;
import business.exceptions.UserException;

import java.sql.*;

public class BookingMapper {
    Database database;
    public BookingMapper(Database database){
        this.database = database;

    }
    public Booking bookItem(Booking booking)throws UserException{
        try(Connection connection = database.connect()){
            String sql = "insert into booking set days = ?, booking_date = ?, booking_status = ?, fk_user_id = ?, fk_item_id = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, booking.getDays());
                ps.setString(2, booking.getBooking_date());
                ps.setBoolean(3, booking.isBooking_status());
                ps.setInt(4, booking.getUser_id());
                ps.setInt(5, booking.getItem_id());
                ps.executeUpdate();
                ResultSet booking_id = ps.getGeneratedKeys();
                booking_id.next();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return booking;
    }

}
