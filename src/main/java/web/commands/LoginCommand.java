package web.commands;

import business.entities.User;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand extends CommandUnprotectedPage
{
    private UserFacade userFacade;

    public LoginCommand(String pageToShow)
    {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String user_mail = request.getParameter("user_mail");
        String user_password = request.getParameter("user_password");

        try {
        User user = userFacade.login(user_mail, user_password);

        HttpSession session = request.getSession();

        session.setAttribute("user", user);
        session.setAttribute("user_role", user.getRole());
        session.setAttribute("user_mail", user_mail);

        String pageToShow =  user.getRole() + "page";
        return REDIRECT_INDICATOR + pageToShow;
        }
        catch (UserException ex)
        {
            request.setAttribute("error", "Wrong username or password!");
            return "loginpage";
        }
    }

}
