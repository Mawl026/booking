package web.commands;

import business.exceptions.UserException;
import business.services.BookingFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowBookingsCommand extends CommandProtectedPage {

    BookingFacade bookingFacade;

    public ShowBookingsCommand(String pageToShow, String role) {
        super(pageToShow, role);
        bookingFacade = new BookingFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        request.setAttribute("listOfBookings", bookingFacade.listOfBookings());
        bookingFacade.updateBooking();

        // return super.execute(request, response);
        return  pageToShow;
    }
}
