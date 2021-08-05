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

        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String user_mail = request.getParameter("user_mail");
        String user_password1 = request.getParameter("password1");
        String user_password2 = request.getParameter("password2");
        int user_phone = Integer.parseInt(request.getParameter("user_phone"));
        int user_credit = Integer.parseInt(request.getParameter("user_credit"));
        String user_role = request.getParameter("user_role");


        if (user_password1.equals(user_password2)) {

            HttpSession session = request.getSession();

            User user = userFacade.createUser(user_mail, user_password1, user_phone, user_credit, user_role);

            session.setAttribute("user_id", user_id);
            session.setAttribute("user_mail", user_mail);
            session.setAttribute("user_password", user_password1);
            session.setAttribute("user_phone", user_phone);
            session.setAttribute("user_credit", user_credit);
            session.setAttribute("user_role", user_role); // or maybe user.getRole(); idk. ??


            request.setAttribute("createUser", user);

            //return user.getRole() + "page"; ??
            return pageToShow;

        }


        else {
            request.setAttribute("error", "the two passwords did not match");

            return "registerpage";
        }
    }

}
