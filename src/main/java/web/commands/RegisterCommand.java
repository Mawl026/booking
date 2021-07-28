package web.commands;

import business.entities.User;
import business.persistence.Database;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand extends CommandProtectedPage {
    private UserFacade userFacade;

    public RegisterCommand(String pageToShow, String role)
    {
        super(pageToShow, role);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        int phone = Integer.parseInt(request.getParameter("phone"));
        int credit = Integer.parseInt(request.getParameter("credit"));
        String role = request.getParameter("role");

        if (password1.equals(password2)) {

            User user = userFacade.createUser(email, password1, 0,0, role);
            HttpSession session = request.getSession();

            session.setAttribute("email", email);
            session.setAttribute("password", password1);
            session.setAttribute("phone", phone);
            session.setAttribute("credit", credit);
            session.setAttribute("role", role); // or maybe user.getRole(); idk.

            //return user.getRole() + "page";
            return pageToShow;

        }


        else {
            request.setAttribute("error", "the two passwords did not match");

            return "registerpage";
        }
    }

}
