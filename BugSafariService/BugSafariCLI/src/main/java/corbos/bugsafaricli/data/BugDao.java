package corbos.bugsafaricli.data;

import corbos.bugsafaricli.models.Bug;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BugDao implements Dao {

    private static final String FILE_PATH = "bugs";
    private static final String DELIMITER = "::";

    @Override
    public Bug create(Bug bug) throws DataException {
        int bugId = 0;
        List<Bug> all = findAll();
        for (Bug b : all) {
            bugId = Math.max(bugId, b.getBugId());
        }
        bug.setBugId(bugId + 1);
        all.add(bug);

        save(all);

        return bug;
    }

    @Override
    public boolean update(Bug bug) throws DataException {
        List<Bug> all = findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getBugId() == bug.getBugId()) {
                all.set(i, bug);
                save(all);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean delete(int bugId) throws DataException {
        List<Bug> all = findAll();
        for (Bug b : all) {
            if (b.getBugId() == bugId) {
                all.remove(b);
                save(all);
                return true;
            }
        }
        return false;
    }

    @Override
    public Bug findById(int bugId) throws DataException {
        for (Bug b : findAll()) {
            if (b.getBugId() == bugId) {
                return b;
            }
        }
        return null;
    }

    @Override
    public List<Bug> findAll() throws DataException {
        ArrayList<Bug> all = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Bug bug = unmarshall(line);
                if (bug != null) {
                    all.add(bug);
                }
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            throw new DataException(ex.getMessage(), ex);
        }
        return all;
    }

    private void save(List<Bug> bugs) throws DataException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Bug b : bugs) {
                writer.println(marshall(b));
            }
        } catch (IOException ex) {
            throw new DataException(ex.getMessage(), ex);
        }
    }

    private String marshall(Bug b) {
        return b.getBugId() + DELIMITER
                + b.getCommonName() + DELIMITER
                + b.getLatinName();
    }

    private Bug unmarshall(String line) {

        String[] tokens = line.split(DELIMITER);
        if (tokens.length != 3) {
            return null;
        }

        Bug bug = new Bug();
        bug.setBugId(Integer.parseInt(tokens[0]));
        bug.setCommonName(tokens[1]);
        bug.setLatinName(tokens[2]);
        return bug;
    }
}
