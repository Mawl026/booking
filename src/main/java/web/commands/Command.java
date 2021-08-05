package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command
{
    //Return a token string from the execute method to make a client side redirect,
    // instead of a server side (forward) redirect
    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";
    public final static String WAS_NOT_FOUND_COMMAND ="404_NOT_FOUND";

    private static HashMap<String, Command> commands;
    public static Database database;

    private static void initCommands(Database database)
    {
        commands = new HashMap<>();
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("loginpage", new CommandUnprotectedPage("loginpage"));
        commands.put("logincommand", new LoginCommand(""));
        commands.put("logoutcommand", new LogoutCommand(""));
        commands.put("registerpage", new CommandProtectedPage("registerpage", "teacher"));
        commands.put("registercommand", new RegisterCommand("","teacher"));
        commands.put("studentpage", new CommandProtectedPage("studentpage", "student"));
        commands.put("teacherpage", new CommandProtectedPage("teacherpage", "teacher"));

        commands.put("listofstudentspage", new CommandProtectedPage("listofstudentspage", "teacher"));
        commands.put("listofstudentscommand", new ListOfStudentsCommand("listofstudentspage", "teacher"));

        commands.put("listofitemspage", new CommandProtectedPage("listofitemspage","teacher"));
        commands.put("listofitemscommand", new ListOfItemsCommand("listofitemspage", "teacher"));

        commands.put("listofbookingspage", new CommandProtectedPage("listofbookingspage", "teacher"));
        commands.put("listofbookingscommand", new ListOfBookingsCommand("listofbookingspage", "teacher"));

    }

    public static Command fromPath(
            HttpServletRequest request,
            Database db)
    {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null)
        {
            database = db;
            initCommands(database);
        }

        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }

    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException;

}
