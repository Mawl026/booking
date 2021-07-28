package web.commands;

import business.exceptions.UserException;
import business.services.ItemFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListOfItemsCommand extends  CommandProtectedPage {

    ItemFacade itemFacade;

    public ListOfItemsCommand(String pageToShow, String role) {
        super(pageToShow, role);
        itemFacade = new ItemFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        request.setAttribute("listOfItems", itemFacade.listOfItems());

        // return super.execute(request, response);
        return pageToShow;
    }
}
