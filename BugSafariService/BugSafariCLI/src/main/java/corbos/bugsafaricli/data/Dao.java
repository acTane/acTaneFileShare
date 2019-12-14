package corbos.bugsafaricli.data;

import corbos.bugsafaricli.models.Bug;
import java.util.List;

public interface Dao {

    Bug create(Bug bug) throws DataException;

    boolean delete(int bugId) throws DataException;

    List<Bug> findAll() throws DataException;

    Bug findById(int bugId) throws DataException;

    boolean update(Bug bug) throws DataException;

}
