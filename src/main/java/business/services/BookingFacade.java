package business.services;

import business.entities.Booking;
import business.exceptions.UserException;
import business.persistence.BookingMapper;
import business.persistence.Database;

public class BookingFacade {

    private BookingMapper bookingMapper;

    public BookingFacade(Database database) {

        this.bookingMapper = new BookingMapper(database);

    }

    public Booking bookingAnItem(String booking_date, int days, String comment, boolean booking_status, int user_id, int item_id) throws UserException {

        Booking booking = new Booking (booking_date, days, comment, booking_status, user_id, item_id);
        booking = bookingMapper.bookAnItem(booking);

        return booking;
    }
}
