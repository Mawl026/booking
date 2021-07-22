package web.commands;

import business.entities.Booking;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.UserMapper;
import business.services.BookingFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

public class CreateBookingCommand extends CommandProtectedPage {
    UserFacade userFacade;
    UserMapper userMapper;

    BookingFacade createBookingFacade = new BookingFacade(database);


    public CreateBookingCommand(String pageToShow, String role) {
        super(pageToShow, role);

        userFacade = new UserFacade(database);
        userMapper = new UserMapper(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int user_id = user.getUser_id();
        int item_id = Integer.parseInt(request.getParameter("item"));
        int booking_days = 0;
        boolean booking_status = false;

        try {
            booking_days = Integer.parseInt(request.getParameter("days" + item_id));

        }

        catch (NumberFormatException nfe) {
            throw new UserException("Venligst indtast antal dage, tak.");

        }

        LocalDate booking_date = LocalDate.now(); // .plusDays(days);

        String booking_comment = request.getParameter("comment");
        Booking createBooking = createBookingFacade.createBooking(String.valueOf(booking_date), booking_days, booking_comment, booking_status, user_id, item_id);
        // call a method in the UserMapper by name: useCredit(int credit)
        userFacade.useCredit(booking_days, user_id);
        request.setAttribute("booking", createBooking);

        return pageToShow;
        // return super.execute(request, response); ?
    }
}
