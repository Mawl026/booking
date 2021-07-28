package web.commands;

import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListOfStudentsCommand extends  CommandProtectedPage {

    UserFacade userFacade;

    public ListOfStudentsCommand(String pageToShow, String role) {
        super(pageToShow, role);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        request.setAttribute("listOfStudents", userFacade.listOfStudents());

        // return super.execute(request, response);
        return pageToShow;
    }
}
