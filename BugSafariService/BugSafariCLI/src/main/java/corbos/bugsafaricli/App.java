package corbos.bugsafaricli;

import corbos.bugsafaricli.controllers.Controller;
import corbos.bugsafaricli.data.BugDao;
import corbos.bugsafaricli.service.BugServiceImpl;
import corbos.bugsafaricli.service.BugServiceInterface;
import corbos.bugsafaricli.ui.UserIO;
import corbos.bugsafaricli.ui.View;

public class App {

    public static void main(String[] args) {

        UserIO io = new UserIO();
        View view = new View(io);
        BugDao dao = new BugDao();
        BugServiceInterface myService = new BugServiceImpl(dao);
        
        
        Controller controller = new Controller(view, myService);

        controller.run();
    }
}
