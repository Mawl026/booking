package business.persistence;

import business.entities.Booking;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingMapper {
    Database database;
    public BookingMapper(Database database){
        this.database = database;

    }
    public Booking bookAnItem(Booking booking)throws UserException{
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

    public List<Booking> listOfBookings() throws UserException {
        List<Booking> listOfBookings = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM booking";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int booking_id = rs.getInt("booking_id");
                    String booking_date = rs.getString("booking_date");
                    int booking_days = rs.getInt("days");
                    String booking_comment = rs.getString("comment");
                    boolean booking_status = rs.getBoolean("booking_status");
                    int booking_user_id = rs.getInt("fk_user_id");
                    int booking_item_id = rs.getInt("fk_item_id");


                    Booking booking = new Booking(booking_date, booking_days, booking_comment, booking_status,booking_user_id, booking_item_id);
                    booking.setBooking_id(booking_id);
                    listOfBookings.add(booking);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listOfBookings;
    }

    public void updateBookings() throws UserException {

        try (Connection connection = database.connect()) {
            String sql = "update booking SET booking_status = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setBoolean(1, true);
                ps.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
