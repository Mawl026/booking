package business.services;

import business.entities.Booking;
import business.persistence.BookingMapper;
import business.persistence.Database;

public class BookItemFacade {
    private BookingMapper bookingMapper;
    public BookItemFacade(Database database){
        this.bookingMapper = new BookingMapper(database);
    }
    public Booking bookItem(String booking_date, int days, String comment, boolean booking_status, int user_id, int item_id)
}
