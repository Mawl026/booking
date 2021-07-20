package business.services;

import business.entities.Booking;
import business.exceptions.UserException;
import business.persistence.BookingMapper;
import business.persistence.Database;

import java.util.List;

public class BookingFacade {

    private BookingMapper bookingMapper;

    public BookingFacade(Database database) {
        this.bookingMapper = new BookingMapper(database);
    }

    public List<Booking> listOfBookings() throws UserException {
        return bookingMapper.listOfBookings();
    }

    public void updateBookings() throws  UserException {
        bookingMapper.updateBookings();
    }

    public Booking bookAnItem(String booking_date, int days, String comment, boolean booking_status, int user_id, int item_id) throws UserException {

        Booking booking = new Booking (booking_date, days, comment, booking_status, user_id, item_id);
        booking = bookingMapper.bookAnItem(booking);

        return booking;
    }


}
