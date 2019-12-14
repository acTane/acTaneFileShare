package corbos.bugsafaricli.controllers;

import corbos.bugsafaricli.data.Dao;
import corbos.bugsafaricli.data.DataException;
import corbos.bugsafaricli.models.Bug;
import corbos.bugsafaricli.ui.View;
import java.util.List;

public class Controller {

    private final View view;
    private final Dao dao;

    public Controller(View view, Dao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        int selection = 0;
        do {
            selection = view.displayMenuAndSelect();
            switch (selection) {
                case 1:
                    addBug();
                    break;
                case 2:
                    editBug();
                    break;
                case 3:
                    deleteBug();
                    break;
                case 4:
                    displayAll();
                    break;

            }
        } while (selection > 0);

        view.sayGoodbye();
    }

    private void addBug() {
        Bug bug = view.makeBug();
        try {
            dao.create(bug);
            view.displayMessage(bug.getCommonName() + " created!");
        } catch (DataException ex) {
            view.displayException(ex);
        }

    }

    private void displayAll() {
        try {
            List<Bug> all = dao.findAll();
            view.displayBugs(all);
        } catch (DataException ex) {
            view.displayException(ex);
        }
    }

    private void editBug() {
        int bugId = view.readBugId("Edit Bug");

        try {
            Bug bug = dao.findById(bugId);
            if (bug == null) {
                view.displayMessage("Bug Id " + bugId + " not found.");
                return;
            }
            bug = view.update(bug);
            if (dao.update(bug)) {
                view.displayMessage(bug.getCommonName() + " updated!");
            } else {
                view.displayMessage("Bug Id " + bugId + " not found.");
            }
        } catch (DataException ex) {
            view.displayException(ex);
        }

    }

    private void deleteBug() {
        try {
            int bugId = view.readBugId("Delete Bug");
            if (dao.delete(bugId)) {
                view.displayMessage("Bug Id " + bugId + " deleted.");
            } else {
                view.displayMessage("Bug Id " + bugId + " not found.");
            }
        } catch (DataException ex) {
            view.displayException(ex);
        }
    }
}
