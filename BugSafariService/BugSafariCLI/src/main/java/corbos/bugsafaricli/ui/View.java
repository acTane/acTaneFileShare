package corbos.bugsafaricli.ui;

import corbos.bugsafaricli.models.Bug;
import java.util.List;

public class View {

    private final ConsoleIO io;

    public View(ConsoleIO io) {
        this.io = io;
    }

    public int displayMenuAndSelect() {

        io.print("\nMain Menu");
        io.print("==========");

        io.print("0. [Exit]");
        io.print("1. Add a bug.");
        io.print("2. Edit a bug.");
        io.print("3. Delete a bug.");
        io.print("4. Display all bugs.");

        return io.readInt("Select [0-4]:", 0, 4);
    }

    public void sayGoodbye() {
        io.print("\nGoodbye...");
    }

    public Bug makeBug() {

        io.print("\nAdd a Bug");
        io.print("============");

        Bug bug = new Bug();
        bug.setCommonName(io.readRequiredString("Common Name:"));
        bug.setLatinName(io.readRequiredString("Latin Name:"));
        return bug;
    }

    public void displayMessage(String message) {
        io.print(message);
    }

    public void displayException(Exception ex) {
        io.print("\nERROR");
        io.print("=======");
        io.print(ex.toString());
    }

    public void displayBugs(List<Bug> all) {
        io.print("\nAll Bugs");
        io.print("============");
        if (all.isEmpty()) {
            io.print("No bugs founds.");
            return;
        }

        for (Bug b : all) {
            io.print(b.getBugId() + ": " + b.getCommonName() + ", " + b.getLatinName());
        }
    }

    public int readBugId(String header) {
        io.print("");
        io.print(header);
        io.print("============");
        return io.readInt("Bug Id?:");
    }

    public Bug update(Bug bug) {

        String commonName = io.readString(
                String.format("Common Name (%s):", bug.getCommonName()));
        if (!commonName.isBlank()) {
            bug.setCommonName(commonName);
            
        }

        String latinName = io.readString(
                String.format("Latin Name (%s):", bug.getLatinName()));
        if (!latinName.isBlank()) {
            bug.setLatinName(latinName);
        }
        return bug;
    }

}
