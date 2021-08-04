package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandProtectedPage extends Command
{
    public String user_role;
    public String pageToShow;

    public CommandProtectedPage(String pageToShow, String user_role)
    {
        this.pageToShow = pageToShow;
        this.user_role = user_role;

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        return pageToShow;
    }

    public String getUser_role()
    {
        return user_role;
    }
}
